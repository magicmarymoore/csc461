/**
 * Java OOP
 * Author: Mary Moore
 * Class: Programming Languages - CSC 461 - M01
 * Date: 9/27/2023
 *
 * Checklist:
 * Grading tags in for all lines marked with *		       COMPLETE
 *
 * The visitor pattern is used 				               COMPLETE
 * Handles bad input with 1 try-catch			           COMPLETE
 * Threw the exception in tier 8 (rezone)			       COMPLETE
 *
 * Tier 1: running and menu working 		               COMPLETE
 * Tier 2: set any object at 0, 0 				           COMPLETE
 * Tier 3: set any object a anywhere			           COMPLETE
 * Tier 4: handles bad input at this point			       COMPLETE
 * Tier 5: default grid displays properly 			       COMPLETE
 * Tier 6: count types * 				                   COMPLETE
 * Tier 7: coloring and menus completed*			       COMPLETE
 * Tier 8: Rezone *					                       COMPLETE
 * Tier 9: Fix roads*			  		                   COMPLETE
 *      All adjacent pullable objects removed		       COMPLETE
 *      At least one pullable objects are pulled inwards   COMPLETE
 *
 * NOTE: I did have to use the updated beta RunTests to get the tests to pass, but with that file it worked perfectly!
 */
package moore_mary;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CityStart {
    public static Scanner cin;

    private static final String NUMBER_ERROR_MESSAGE = "Number is out of range";
    private static final String NAN_ERROR_MESSAGE = "Please input an integer";
    private static final String REZONE_ERROR_MESSAGE = "Insufficient open areas";
    private static String MENU_OPTION_1 = "Input tile type 1) greenspace 2) water 3) road 4) building 5) empty:> ";
    private static String MENU_OPTION_1_INPUT = "Input location (x y): ";
    private static String MENU_OPTION_4 = "Input tile type 1) building 2) road 3) non-structure:> ";
    private static String MENU_OPTION_4_INPUT = "Input color 1) red 2) orange 3) blue 4) green 5) black:> ";


    public static void main(String[] args) {

        City c = new City();
        cin = new Scanner(System.in);
        String menu =
                "1) Set Tile\n"+
                "2) Make Default City\n"+
                "3) Count Zones\n"+
                "4) Set Tile Color\n"+
                "5) Rezone\n"+
                "6) Fix Roads\n"+
                "0) Quit\n";
        int input = -1;
        while(input != 0) {
            System.out.println(c);
            System.out.println(menu);
            System.out.print("Choice:> ");

            try {
                input = cin.nextInt();

                switch (input) {
                    // quit
                    case 0 -> {} // intellij suggested I simplify the switch statement to an enchanced switch & gave me this lol

                    // change a single tile
                    case 1 -> changeTile(c);

                    // reset & print out default grid
                    case 2 -> outputDefaultGrid(c);

                    // print count of each type
                    case 3 -> countTiles(c);

                    // change the color
                    case 4 -> changeColor(c);

                    // rezone
                    case 5 -> rezone(c);

                    // fix roads
                    case 6 -> fixRoads(c);

                    // not a menu option
                    default -> throw new IndexOutOfBoundsException(NUMBER_ERROR_MESSAGE);
                }

            } catch(IndexOutOfBoundsException | UnsupportedOperationException e) {
                System.out.println(e.getMessage());
                cin.nextLine();
            } catch(InputMismatchException e) {
                System.out.println(NAN_ERROR_MESSAGE);
                cin.nextLine();
            } catch (Exception e) {
                System.out.println("An exception: " + e + " has occurred. Please try again.");
                cin.nextLine();
            }
        }
    }

    private static void changeTile(City city) throws IndexOutOfBoundsException {
        int type, row, col;

        System.out.println(MENU_OPTION_1);
        type = cin.nextInt();
        if (type < 1 || type > 5)
            throw new IndexOutOfBoundsException(NUMBER_ERROR_MESSAGE);

        System.out.println(MENU_OPTION_1_INPUT);
        col = cin.nextInt();
        if (col < 0 || col > 6)
            throw new IndexOutOfBoundsException(NUMBER_ERROR_MESSAGE);

        row = cin.nextInt();
        if (row < 0 || row > 6)
            throw new IndexOutOfBoundsException(NUMBER_ERROR_MESSAGE);

        city.setTile(intToTile(type, row, col), row, col);
    }

    private static Tile intToTile(int type, int row, int col) {
        return switch (type) {
            case 1 -> new Greenspace(row, col);
            case 2 -> new Water(row, col);
            case 3 -> new Street(row, col);
            case 4 -> new Building(row, col);
            default -> new Empty(row, col);
        };
    }

    private static void outputDefaultGrid(City city) {
        ArrayList<Integer> nums = new ArrayList<>(
                List.of(3,3,3,3,3,3,3,
                        3,4,3,5,3,5,5,
                        3,3,3,3,3,2,2,
                        3,4,3,5,3,1,2,
                        3,4,5,4,3,1,2,
                        3,4,4,4,3,1,2,
                        3,3,3,3,3,1,2)
        );

        for (int row = 0; row < 7; row++)
            for (int col = 0; col < 7; col++)
                city.setTile(intToTile(nums.get(row*7+col), row, col), row, col);
    }

    private static void countTiles(City city) {
        GetCounts visitor = new GetCounts();
        city.accept(visitor); // GRADING: COUNT
        System.out.println(visitor);
    }

    private static void changeColor(City city) throws IndexOutOfBoundsException {
        int type, color;

        System.out.println(MENU_OPTION_4);
        type = cin.nextInt();
        if (type < 1 || type > 3)
            throw new IndexOutOfBoundsException(NUMBER_ERROR_MESSAGE);

        System.out.println(MENU_OPTION_4_INPUT);
        color = cin.nextInt();
        if (color < 1 || color > 5)
            throw new IndexOutOfBoundsException(NUMBER_ERROR_MESSAGE);

        ColorText.Color newColor = switch (color){
            case 1 -> ColorText.Color.RED;
            case 2 -> ColorText.Color.ORANGE;
            case 3 -> ColorText.Color.BLUE;
            case 4 -> ColorText.Color.GREEN;
            default -> ColorText.Color.BLACK;
        };

        city.accept(new ChangeColor(type, newColor)); // GRADING: COLOR
    }

    private static void rezone(City city) throws UnsupportedOperationException {
        GetCounts visitor = new GetCounts();
        city.accept(visitor);

        if (visitor.getEmptyCount() < 5)
            city.accept(new Rezone(city)); // GRADING: REZONE
        else
            throw new UnsupportedOperationException(REZONE_ERROR_MESSAGE);
    }

    private static void fixRoads(City city) {
        city.accept(new FixRoads(city));
    }
}

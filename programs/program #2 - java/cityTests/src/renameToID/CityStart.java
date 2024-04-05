package renameToID;

import java.util.Scanner;

public class CityStart {
    public static Scanner cin;
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

            input = cin.nextInt();
        }


    }

}

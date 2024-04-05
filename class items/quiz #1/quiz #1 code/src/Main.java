import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        scratch alpha = new scratch(2);
        alpha.foo(2);
        scratch beta  = new scratch(6);
        beta.foo(3);

        System.out.println(alpha.x);
        System.out.println(alpha.y);
        System.out.println(beta.x);
        System.out.println(beta.y);

        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Ctrl+D to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);
//        }

        Ellipsoid bigE = new Ellipsoid(2, 2.5, 4);
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Input the x radius: ");
            String line = in.nextLine();
            line = line.trim();
            double x = Double.parseDouble(line);

            System.out.println("Input the y radius: ");
            line = in.nextLine();
            line = line.trim();
            double y = Double.parseDouble(line);

            System.out.println("Input the z radius: ");
            line = in.nextLine();
            line = line.trim();
            double z = Double.parseDouble(line);

            Ellipsoid littleE = new Ellipsoid(x, y, z);
            System.out.println("results: " + bigE.ratio(littleE));

        } catch (  NumberFormatException e ) {
            System.err.println( e.getMessage() + ": bad integer value, please try again." );
        } catch ( Exception e ) {
            System.out.println( "Compiler output----------------" );
            e.printStackTrace(); //straight compiler output...threaded
            System.out.println( e.getClass() ); // the type of exception
            System.out.println( e.getMessage() + ": invalid input, please try again." );
        }

    }
}
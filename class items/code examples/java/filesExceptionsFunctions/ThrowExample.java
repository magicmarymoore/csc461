package filesExceptionsFunctions;

import java.io.IOException;
import java.util.Scanner;

public class ThrowExample {

    //throws says "I don't want to handle it here"
    public static int A() throws IOException {
        System.out.println( "begin A" );
        int x = B();
        System.out.println( "end A" );
        return x;
    }

    public static int B() throws NumberFormatException {
        System.out.println( "begin B" );
        Scanner scan = new Scanner( System.in );
        int x = scan.nextInt( ); //possible error

        //additional check, and force an exception if needed
        if( x < 0 )
            throw new NumberFormatException( "Integer cannot be negative");

        System.out.println( "end B" );
        return x;
    }

    public static void main( String[] args ) {

        System.out.println( "Enter a integer: " );

        //handle all exceptions here
        int x = 0;
        try {
            x = A( );
        } catch( Exception e ) {
            System.out.println( "Ack, that's bad! " + e.getMessage());
        }
        System.out.println( "X: " + x );
    }
    /*
    Question:
    What is printed if the user inputs 2.4 in the above?







    Answer:
    begin A
    begin B
    2.4


     */

}

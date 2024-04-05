package filesExceptionsFunctions;

import java.util.Scanner;

public class ExceptionDemo
{
    // main() - execution begins here
    public static void main( String [] args )		// throws IOException
    {
        boolean loopflag = true;

        while ( loopflag )
        {
            // exception handling: try block catches exceptions
            try
            {
                System.out.println( );
                System.out.print( "Enter two integer values: " );

                // create a buffered reader and read in a line of text
                Scanner in = new Scanner( System.in );
                String line = in.nextLine();
                line = line.trim();			// clean up leading and trailing spaces

                // get first value
                int i = line.indexOf( " " );		// find first space
                String sub = line.substring( 0, i );	// substring containing first integer value
                int m = Integer.parseInt( sub );

                // get rid of first part of line
                line = line.substring( i ).trim();

                // get second value
                int n = Integer.parseInt( line );

                // print results
                System.out.println( "\nThe sum of " + m + " + " + n + " is " + ( m + n ) );
                System.out.println();

                System.out.println( "\nAttempt division " + m + " / " + n + " is " + ( m / n ) );
                System.out.println();

                // exit loop...no errors happened
                loopflag = false;
            }

            //start with hierarchy
            // exception handling: catch() block handles exceptions are HIERARCHICAL
            //add in specific to general order
            catch (  NumberFormatException e )
            {
                System.err.println( e.getMessage() + ": bad integer value, please try again." );
            }
            catch ( StringIndexOutOfBoundsException e )
            {
                System.out.println( e.getMessage() + ": need two integer values, please try again." );
            }
            catch ( Exception e ) //good idea to have this
            {
                System.out.println( "Compiler output----------------" );
                e.printStackTrace(); //straight compiler output...threaded
                System.out.println( e.getClass() ); // the type of exception
                System.out.println( e.getMessage() + ": invalid input, please try again." );
            }finally{
                System.out.println( "in finally block----------------" );
            }

            //last note: catch can be combined with |
            //catch ( StringIndexOutOfBoundsException | NumberFormatException e )
        }
    }
}

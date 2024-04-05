package filesExceptionsFunctions;


public class CommandArguments
{
    public static void main( String [] args )
    {
        System.out.println( args.length + " command-line arguments:" );
        
        // print arguments using a for loop
         for ( int i = 0; i < args.length; i++ )
             System.out.println( args[i] );
            
        // better: use a foreach loop
        for ( String arg : args )
            System.out.print( " " + arg );
            
        System.out.println();
    }
}

/*
To set command line arguments...
Click current starter class (upper right)
--> Edit configuration
--> program arguments
 */

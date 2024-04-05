package filesExceptionsFunctions;

import java.io.IOException;
import java.util.Scanner;


public class FunctionAndWrapperDemo
{
    /*
    function basic format: access returnType name(paramterlist){...}
    'access' defaults to package-private

    Similar to C++ BUT
    1) Every function is associated with a class
    2) Can’t pass a primitive by reference
    3) No &
    4) No *
    5) Without making a new class, main() can only call static functions (since main() is static)

     */
    // main() - execution begins here
    public static void main( String [] args ) throws IOException
    {
        System.out.print( "Enter two integer values: " );
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        // print results, will fail
        add(m,n);
        System.out.println( "\nThe sum of " + m + " + " + n + " is " + m );

        // print results, will fail
        Integer x = m;
        addWrapper(x,n);
        System.out.println( "\nThe sum of WRAPPER " + m + " + " + n + " is " +x );
        System.out.println();

        // print results, will work
        MutableInt x2 = new MutableInt(m);
        MutableInt x3 = new MutableInt(n);
        addMutable(x2,x3);
        System.out.println( "The sum of Mutable wrapper " + m + " + " + n + " is " +x2.val );
        System.out.println();

        // print results, will work
        int[] a= new int[]{m};
        int[] b= new int[]{n};
        addArray(a,b);
        System.out.println( "The sum of array wrapper " + m + " + " + n + " is " +a[0] );
        System.out.println();

    }

    //fails to update
    private static void add(int x, int y){
        x = x+y;
    }

    //fails to update
    //wrappers are immutable
    public static void addWrapper(Integer x, Integer y){
        x = x+y;
    }

    //updates BAD!!!!!!
    public final static void addArray(int[] x, int[] y){
        x[0] = x[0]+y[0];
    }

    //updates
    static class  MutableInt {
        int val;
        public MutableInt(int x)
        {
            val = x;
        }
    }
    public static void addMutable(MutableInt x, MutableInt y){
        x.val = x.val+y.val;
    }

    //comments----------------------------------------


    /**
     * Java doc!
     * Typing /** and then enter above a function will autofill some of this
     * Example !!!
     * @param x stuff
     * @param b stuff 2!
     * @return zero
     */


    /**
     *
     * @param x
     * @param b
     * @return
     */
    public int example(int x, String b) {
        return 0;
    }

    /*
    Last tips:

    1) to build documentation: ToolsGenerate JavaDoc
    2) check for empty tags in functions: AnalyzeInspect code
       2a) then in the output window under JavaJavaDoc
        note: Inspect code outputs WAY too much
    3) For REALLY nice style check, add the Checkstyle plugin (OPTIONAL)
          (FileSettingsPlugintype in Checkstyle in the search box)
     */


}



package advancedDataTypes;

public class Strings
{
    public static void repeat(String str){
        str = str + str;
    }

    public static void main( String [] args )
    {String s = "Hello, world!";
        System.out.println( s + " = " + s.length() ); //appending to string far easier in Java

        //still can access individual characters
        for(int i = 0; i < s.length();i++)
        {
            System.out.println(s.charAt(i));
        }

        //some String concerns
        {
            String str = "text";
            repeat(str); //strings are immutable, so nothing happens
            if ("text" == str) {
                System.out.println("Should not reach since == is comparing references");
            }
            if ("texttext" == str) {
                System.out.println("Should not reach since == is comparing references");
            }
            if ("texttext".equals(str)) {
                System.out.println("Should not reach since Strings are immutable");
            }
        }

        //it is easy to split a string
        {
            String[] split = s.split(" ");
            System.out.println("Split the string: ");
            for (int i = 0; i < split.length; i++) {
                System.out.print(split[i] + ".......");
            }
            System.out.println();
        }


    }
}


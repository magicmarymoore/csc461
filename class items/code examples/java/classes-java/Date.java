/*
Similar to C++ classes, but with several significant differences
----Single inheritance (May implement interfaces)
----Late binding is default
----Top level class access modifier: public or package
----Nested classes have private and protected too


Reminder:
Java is VERY picky about folder structure
“import package” is similar to “using namespace” in C++
Package name corresponds to pathname on file system:
package.name.class.method
				method in "package/name/class.java"

 */
package classes;

import java.util.Calendar;

public class Date //<--same name as file
{
    private int month, day, year;

    // default no-argument constructor function
    //no explicit parent? Then, Object is the implicit parent
    //https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html
    public Date() {
        this( 1, 1, 1970 ); //forward construction
    }

    // 3-argument constructor function
    //adding this will remove implicit no-arg constructor
    public Date(int m, int d, int y ) {
        month = m;
        day   = d;
        year  = y;
    }

    //!!! No destructors due to garbage collection  !!!!
    //other methods below-----------------------------------------------------


    //Yep, main in the same class!
    //I can STILL make DATE in another class\file, and main will be skipped
    //
    //NOTE: this is NOT good practice, but I didn't want to separate the code
    //Essentially, this is a cheap test bed option
    public static void main(String[] args) {
        //instantiate the same class, it should be for testing ONLY
        Date date1 = new Date();
        Date date2 = new Date(1,1,2000);
        Date date3 = new Date(2,1,2000);
        Date date4 = Date.getCurrent(); //refresher: this is a CLASS method (may have called it a static method)

        System.out.println("Date 1: " + date1); //toString implicitly called
        System.out.println("Date 2: " + date2);
        System.out.println("Date 3: " + date3);
        System.out.println("Current Date: " +date4);
        System.out.println("Date 1 and 2 equal: " +date1.equals(date2));
        System.out.println("Date 2 and 3 equal: " +date2.equals(date3));
        System.out.println("Date and string NOT equal: " +date2.equals("stuff"));
        date3.setMonth( 1 ); //refresher: this is a INSTANCE method
        System.out.println("Date 2 and 3 equal after update: " +date2.equals(date3));
    }


    public void setMonth(int m) {
        month = m;
    }

    //static--> class
    public static Date getCurrent(){
        Calendar time = Calendar.getInstance();
        return new Date(time.get(Calendar.MONTH),
                time.get(Calendar.DAY_OF_MONTH),
                time.get(Calendar.YEAR));
    }

    // convert a Date object to a String (usually for output)
    //overrides Object’s version (HIGHLY suggested)
    @Override
    public String toString( )
    {
        return String.format( "%02d/%02d/%02d", month, day, year );
    }

    /* test for object equality (Clean version, but not truly overridden)
     WARNING: equals( Object) still exist even if this is defined
     BUT it switches to default behavior which is comparing the memory addresses
     */
    public boolean equals( Date rhs )
    {
        // see if month/day/year all match up
        return month == rhs.month && day == rhs.day && year == rhs.year;
    }

    /**
     * An example on how to do the Object version properly!
     * @param rhs should be a Date class
     * @return true if rhs is a Date and the month, day, year match!
     */
    public boolean equals( Object rhs )
    {
        Date right;
        try{
            right = (Date)rhs;
        }catch (ClassCastException e){
            System.out.println("In equals(Object):  Not the same object type!!");
            return false;
        }
        // see if month/day/year all match up
        return month == right.month && day == right.day && year == right.year;
    }


}
/*
Question:
Which ones of these should be better as instance methods and which should be class methods?
A) Getter/setters
B) Print usage of a class
C) Return a copy of text in lower case
D) Increment state information







Answer:
A) Getter/setters --> instance
B) Print usage of a class --> class
C) Return a copy of text in lower case --> class (if String.lower("stuff")) and instance if "aBC".lower())
D) Increment state information --> instance

 */


/*
Question:
    Write a square class with a constructor that takes in an integer side length,
    and prints the area.













Answer:
public class Square {
    private int side = 0;
    public Square(int side){
        this.side = side;
    }

    public void printArea()
    {
        System.out.println("Area: " + (side*side));
    }

    public static void main(String[] args) {
        Square s = new Square(2);
        s.printArea();
    }
}
*/

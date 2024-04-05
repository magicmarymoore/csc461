package advancedDataTypes;

public class EnumExample {
    /*
    Enums were not originally part of the JAVA language (and it shows)
    Enums are STILL a class, but with syntatic sugar
     */

    //Java will make these similar to a static final class variable
    public enum Month {
        JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST,
        SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
    }

    public static void main(String[] args) {
        Month m;
        m = Month.JANUARY; //JANUARY is a special reference, not a primitive

        System.out.println("Basic output: " + m);
        System.out.println("Name: " + m.name());
        System.out.println("Ordinal: " + m.ordinal());
        System.out.println("Equality with enum: " + (m == Month.JANUARY));
        //System.out.println("Equality with enum: " + (m == 0)); //fails since Java will not implicitly cast
        System.out.println("Equality with int: " + (m.ordinal() == 0)); ///save to file


        //conversion from file example
        Month m2 = Month.values()[1];
        System.out.println("Convert: " + m2);
    }
}

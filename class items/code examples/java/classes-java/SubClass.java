package classes;

/*
basic format for inheritance:
   DerivedClass extends ParentClass

NOTE: no modifiers on inheritance



 */

import classes.Lights.Lightbulb;

public class SubClass extends SuperClass {
    /*
    Object creation (Same as C++):
      first invoke parent class constructor
     then derived class constructor

     */
    public SubClass() {
        super();   // OK but redundant (superclass constructor called automatically if not done explicitly)
        System.out.println( "Classes.SubClass constructor" );

    }

    //@override is OPTIONAL and says to double check I have a match in the ancestors
    //Late binding (C++ virtual) is default
    @Override
    public void printHello() {
        ///super();             // error: only allowed as first statement in constructor
        super.printHello();     // calling parent methods via "super" is OK
        System.out.println(
                "Hello from Classes.SubClass" );
    }

    @Override
    public void printHelloOverwrite() {
        System.out.println(
                "Hello from Classes.SubClass (overwrite)" );
    }

    public static void main( String[] args ) {
        //Question: what will this output?
        SubClass obj = new SubClass();
        obj.printHello();
        System.out.println("");
        obj.printHelloOverwrite();

    }
}

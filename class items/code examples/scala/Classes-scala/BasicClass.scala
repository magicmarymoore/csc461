package Classes

/*basic format:
 class <name> (propertyList) {...}


   To use:
     val a = new BasicClass(<propertyList>)
     a.funct(...) //normal function access (for Scala anyway)

 A few major notes.
    member variable are not necessarily defined inside the class?!
    Property values defined in class propertyList are added as members,
    AND are PUBLIC by default
    The ONLY constructor the _class_ syntax permits, is the one with the
        full property list!
*/


//class--> INSTANCE stuff
//reminder: //x and y are PUBLIC instance variables
class BasicClass(val x: Int, var y: Int = 2) { //little like __init__(self)

    //no modifier: still an PUBLIC instance variables, with val/var rules
    //java --> no modifier package-private, Scala --> public
    val z = 3
    var z2 = 2

    //private/public/protected still there...and much, MUCH more
    private val z3:Int = 2
    protected val z4:Int = 2


    def print(): Unit = println("In the Stuff class")
}

/*
object is considered a "companion" object.
The names MUST match to make the association

object --> CLASS/STATIC stuff including constructors!
 */
object BasicClass {

    val myStatic = 3    //variables here are static/class variable
    var z = 2           //ironically still work thanks to shadowing

    //apply is a Constructor, IF the class is the  return type
    //different return type? Acts like a regular static function!
    //Are Constructors static or an instance function?
    def apply(): BasicClass = {
        //the main purpose is to act like a factory to make a "new" instance
        new BasicClass(2)

    }

    //we are permitted different apply(...) functions
    //if no apply(), Scala makes a default constructor, that doesnt' need new,
    //that matches the above "class" part
    def apply(x : Int): BasicClass = {
        //the main purpose is to act like a factory to make a "new" instance

        new BasicClass(x)
    }

    //Question: is this static/class function, or a instance function?
    def foo() : Unit = println("Static: here in foo")




    //ANSWER:
    // static
    // BasicClass.foo()
}



object TestStuff extends App {

    val a = new BasicClass(1) //new is required without object section, and goes straight to the class section
    a.print()
    println(a.x)
    println(a.y)
    println(a.z)
    //a.x = 2 // reassignment to immutable...will not compile
    a.y = 0

    println()
    val b = BasicClass(4) //"new" NOT required with "apply" constructor
    b.print()
    println(b.x)
    println(b.y)
    println(a.z)

    println()
    val c = BasicClass()
    c.print()

    //static functions!
    println()
    BasicClass.foo()
    println(BasicClass.myStatic)
}

/*
QUESTION:
Consider how to write a circle class. The only property (member variable)
is the radius.

You want a public get and set access for the radius, and a static AND instance
method to determine the area of a circle. You must allow for this usage:

val a = Circle(2.5)
a.area()
Circle.area(3)

 */

//start here




//ANSWER
class Circle(var radius : Double){ //val a = new Circle(rad)

    def area(): Double = {        //a.area()
        Math.PI * radius * radius
    }
}
object Circle{
    def apply(radius : Double) : Circle = { //val b = Circle(rad)
        new Circle(radius)                  //b.area()
    }
    def area(radius : Double): Double = {   //Circle.area(rad)
        Math.PI * radius * radius
    }
}





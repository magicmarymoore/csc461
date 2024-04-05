package FileAndFunctions


object Functions extends App {

  //-----------Basic Syntax----------------------------------------------------------------------
  /*
    def name([param : type, param2 : type, …])[: ReturnType] = {
      …
      //assumes the last line run is the return, but "return" is legal
    }


    To use:
    name(...)

   */



  def foo(): String = {
    "foo" //returns "foo"
  }

  // datatype syntax follows scala syntax,
  // but otherwise works like it does in java
  // Unit-->void
  private def who() : Unit = {
    println("No return here!")
  }

  //one line function does not need the {}
  //no parameter also can have no ()
  //STILL a function, with return type inferred...
  // WARNING: this type inference can come back and haunt you
  def goo2 = "Goo2!"

  val a = foo()
  val c = goo2
  println(s"foo: $a.toString")
  println(s"goo2 (no () needed since it is parameterless): $c")
  println(s"who: ${who()}") //order of function in block does not matter

  /*
  Convention:
    Even if you have no parameters, add the ()
    if there are ANY side effect (that includes printing!)

   */


  //more parameters--------------------------------

  def add(a: Int, b: Int): Int = {
    a + b
  }

  //overload
  def add(a: Double): Double = {
    a + 2.0
  }

  //Defaults parameters are permitted
  private def addDefault(a: Int = 1, b: Int = 1): Int = {
    a + b
  }

  /*
  Note: while overloaded methods are OK, they may NOT have
  default arguments with different data types.

  For example, this will fail:
  def addDefault(a: String = "test", b: Int = 1): String = {
      a * b
  }

   */


  //why? Look at the last println of this set, and take a guess!
  println(s"add 2 and 3: ${add(2, 3)}")
  println(s"add 2 and whatever the function wants: ${add(2)}")
  println(s"add 2 and default: ${addDefault(2)}")
  println(s"add named second parameter: ${addDefault(b = 2)}")



  /*
  QUESTION:
  Write a hypotenuse function in Scala that has a
  default length of 1 for a and b. Return the square root of c.
  */




  //ANSWER
  def hypotenuse(a: Double = 1, b: Double = 1): Double = {
    val c2 = a * a + b * b
    Math.sqrt(c2)
  }

}

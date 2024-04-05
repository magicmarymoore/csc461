package FileAndFunctions

import scala.io.StdIn
import scala.util.Try

object Exceptions extends App {

    //same as Java's "throw  ArithmeticException" in scala syntax
    @throws[ArithmeticException]
    def badDivision(): Unit = {
        val x = 3 / 0
    }

    println("Exceptions in Scala work very similar to Java...down to reusing Java exceptions!")
    println(
        """
          |The main differences are
          |1) there are no checked expressions
          |2) the catch part follows the Scala match syntax
        """.stripMargin)

    try {
        print("Input an Double when it expects a Int: ")
        val a = StdIn.readInt

        if( a < 0)
            throw new IndexOutOfBoundsException("Need a positive")

        badDivision()
    } catch {
        //this syntax of var : datatype => ...is "type matching"
        case e: NumberFormatException => println(s"Error: needed an integer")
        case e : Throwable => println(s"Error: $e")
        //case e => println(s"Error: ${e.getMessage}") //also work
    }


    //More type safe string conversion with try-catch shorthand
    println("\nWe can check for conversion with the Try() function")
    //Try() returns a wrapper around the exception if there is one
    var tryInfo = Try("3.14".toInt)
    val isInt = tryInfo.isSuccess //will be true if there is no exception
    val isDouble = Try("3.14".toDouble).isSuccess

    print("Is it safe to convert \"3.14\" into a Int: ")
    println(isInt)
    print("Is it safe to convert \"3.14\" into a double: ")
    println(isDouble)



    /*
    QUESTION:
    Write a try-catch block that can catch a NullPointerException and
    print “no data”,  and any other exception and print “error”.





    ANSWER:
    try {
        var x = null
        x.toString
    } catch {
        case e: NullPointerException => println(s"no data")
        case e : Throwable => println(s"error")
    }
    val success = Try(x.toString).isSucess
     */



}

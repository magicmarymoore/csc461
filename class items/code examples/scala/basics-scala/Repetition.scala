package Basic

import scala.io.StdIn
import scala.util.control.Breaks._

object Repetition extends App {


    //<editor-fold desc="while and do-whiles----------------------------">

    println("While loop")
    var x = 1
    //same as Java!
    while (x != 0) {
        print(s"Input a integer (stop with 0): ")
        x = StdIn.readInt
    }

    x = -1
    //Preferred syntax
    while x != 0 do {
        print(s"Input a integer (stop with 0): ")
        x = StdIn.readInt
    }

    println("do-While loop SORT of dropped")
    //</editor-fold>


    //<editor-fold desc="for loop is a range loop----------------------------">

    //adds Python like range/counting loops------------------------
    println("\n\nfor loop as a counting loop, inclusive")
    for (i <- 0 to 4) {
        print(s"$i ")
    }
    println()

    println("for loop as a counting loop, exclusive of end")
    for (i <- 0 until 4) {
        print(s"$i ")
    }
    println()

    println("for loop as a counting loop, exclusive of end, by 2")
    for (i <- 0 until 4 by 2) {
        print(s"$i ")
    }
    println()

    println("for loop with doubles")
    for (i <- BigDecimal(0.5) until 4.5 by 2) { //regular floats are no longer work
        print(s"$i ")
    }
    println()

    println("It is possible to break out. Needs scala.util.control.Breaks._")
    breakable { //mark the block as permitting break
        for (i <- 0 until 10) {
            print(s"$i ")

            if (i == 4)
                break //break
        }
    }
    println()
    /*
          QUESTION: Why do you think they made this so hard?




          Answer:
              A for loop's proper usage is "supposed" to have a set number of iterations!
          */

    //with the "everything returns something" part of scala, this is legal!
    println("{} rather than () also works...with nesting!!")
    for {i <- 0 until 3; j <- 0 until 3} {
        print(s"i$i j$j ${i * j} ")
    }
    println()
    //</editor-fold>


    //<editor-fold desc="for each----------------------------">

    val nums = List((Math.random() * 100).toInt,
        (Math.random() * 100).toInt,
        (Math.random() * 100).toInt,
        (Math.random() * 100).toInt,
        (Math.random() * 100).toInt)
    println(s"\n\nRandom numbers for testing next loops: $nums")

    println("for each loop")
    for (i <- nums) {
        print(s"$i ")
    }
    println()

    println("for each loop with indices")
    for ((value, index) <- nums.zipWithIndex) {
        println(s"$index is $value")
    }
    //</editor-fold>


}

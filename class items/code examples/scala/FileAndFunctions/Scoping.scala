package FileAndFunctions

object Scoping extends App {

  //-----------Scoping------------------------------------------------------------------------------------------

  println("\n\n\n------------Scoping--------")
  var x = 2

  //initially the same scoping rules as C++/Java
  {
    val x = 0 //will use inner x
    println(x)
  }

  {
    val y = x //will use outer x
    println(y)
  }


  def f(y: Int) = y + 1

  //any {} returns a value!
  //QUESTION: what does this return?
  val result = {
    val x = f(3)
    x * x
  } + x
  println(s"Scala has static scoping: $result")


  /*
  Explanation:
      val x = f(3) //f(3) returns 4
      x * x //returns 16
      } + x //out of block, so x is still 2, so 16 + 2
   */






  //QUESTION: what does this return?
  var x2 = 2
  private val result2 = {
    x2 = f(3)  //4
    x2 + x2 //4+4
  } + x2
  println(s"Scala has static scoping: $result2")

  /*
  Explanation:
    x2 = f(3) //did NOT shadow this time, so...? [f(3) returns 4]
    x2 + x2 // this yields 8, but I did not update x2!
    } + x2 //the block yields 8, and x2 is now 4, so 12 total
  */


}

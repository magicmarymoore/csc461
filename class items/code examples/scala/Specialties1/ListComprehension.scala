package Specialties

case class SampleA(var x: Int, var y: Int) {
  override def toString: String =
    "(" + x + ", " + y + ")"
}

object ListComprehension extends App {

  //list comprehensions
  val comprehensionExamples: Unit = {
    //syntactic sugar to nest 2 for-eachs
    for (x <- 1 to 5; y <- 1 to 5) {
      print(f"${x * y}%5d ")
      if (y == 5)
        println()
    }

    //the below is syntactic sugar for the above
    //t
    println("There isn't a limit to the number...2d array multiplication type")
    var t = for {
      x <- 1 to 5
      y <- 1 to 5
    } yield {
      x * y
      //print(f"${x * y}%5d ")
      //if (y == 5)
      //println()
    }

    //Aside: This even supports optional filtering(e.g. 0 to 4) on the list!

    println()
  }

}



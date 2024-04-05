package Specialties

object RepetitionOptional extends App {
  //fancy for loops (starting with functional programming)
  {
    val nums = List((Math.random() * 100).toInt,
      (Math.random() * 100).toInt,
      (Math.random() * 100).toInt,
      (Math.random() * 100).toInt,
      (Math.random() * 100).toInt)

    println("for each loop with even filtering")
    for (i <- nums if i % 2 == 0) {
      print(s"$i ")
    }
    println()

    println("for each loop with even filtering, AND returning the values!")
    val evens = for (i <- nums if i % 2 == 0) yield i

    print(s"Evens variable contains: $evens ")
    println()


  }

  /*
  QUESTION
  Write a for loop that returns the cube of all items in a list called x.




  ANSWER:
  val x2 = List(1,2,3,4,5,6)
  val cubes = for (i <- x2 ) yield i*i*i
  print(cubes)

  OR

  val x2 = List(1,2,3,4,5,6)
  var cubes = List[Int]()
  for (i <- x2 ){
      cubes :+= i*i*i
  }
  print(cubes)



  REMINDER: while Scala will allow you to use imperative programming,
  it is NOT where it shines. This means try to use list comprehensions*
  whenever possible


  *e.g. newList = list.someFunc(…)

   */
}

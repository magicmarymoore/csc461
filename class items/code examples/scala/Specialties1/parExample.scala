package Specialties

import scala.collection.parallel.ParSeq
import scala.collection.parallel.CollectionConverters._

object parExample extends App{

  val fibList: List[Int] = List(1, 1, 2, 3, 5, 8, 13, 20)

  println("\nScala makes running parallel code ridiculously easy")
  println("par returns a ParSeq[...] which will run the below parallel ready options in parallel!---------------------")
  val parList = fibList.par
  println(parList.map(_ * 3))


  /*
  QUESTION: Write code to concurrently find the sum of fibList?
   */





  //ANSWER
  val parList2 = fibList.par
  println(parList2.reduce(_ + _))


  //a few more example of how par works
  val r = Range(0, 100, 1)
  println(r.fold("-")("|"+ _ + "." + _.toString+ "!"))
  println(r.par.fold("-")("|"+ _ + "." + _.toString+ "!"))

}

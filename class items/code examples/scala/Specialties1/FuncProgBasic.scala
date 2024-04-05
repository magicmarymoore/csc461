package Specialties

case class Sample(var x: Int, var y: Int) {
  override def toString: String =
    "(" + x + ", " + y + ")"
}

object FuncProgBasic extends App {

  val temp: List[Int] = List(3, 5, 9, 1, 2, 0, 1, 12)
  val fibList: List[Int] = List(1, 1, 2, 3, 5, 8, 13, 21)
  val fibEndsList: List[Int] = List(1, 1, 13, 21)
  val nestedList = List(List(1, 1, 12, 20), List(3, 5, 8, 12))
  val sampleList = List(SampleA(1, 4), SampleA(2, 3), SampleA(3, 2), SampleA(4, 1))


  println("Scala has a huge number of functional functions")


  println("Main List in question will be: ")
  //list.doXonEachItem( func )
  fibList.foreach(i => print(s"$i ")) //foreach this way takes a Unit lambda function
  println("\nAlso in normal for each code (which has better debugging capabilities)")
  for (i <- fibList) {
    print(s"$i ")
  }
  println()

//the basics of functional, map, filter, reduce------------------------------------
  println("\n\nfilter works like you would expect-----------------------------------------")
  val filtered = fibList.filter(_ % 2 == 0) //this is syntactic sugar for (i=>i % 2 == 0)
  println(filtered)

  println("\n\nfilter frequently is followed by map which needs a lambda or another function-------------")
  val mapped = filtered.map(x => x * x)
  println(mapped)

  println("\n\nReduce merges the list using the first element as the starting value-------------------------------")
  val reduced = fibList.reduce(_ * _) //1 * 1 = 1... 1 * 2 = 2....2 * 3 = 6....6* 5 = 30....
  println(reduced)

  //and parallel
  println("par returns a ParSeq[...] which will run the below parallel ready options in parallel!---------------------")
  import scala.collection.parallel.CollectionConverters._
  val parList = fibList.par
  println(parList.map(_ * 3))








  //filtering/segmenting functions----------------------------------------------------------------
  println()
  println()
  println("More Filtering/segmenting functions----------------------------------------------------------------")

  println("\n\nPartition is similar to filter. The main difference is that it keeps BOTH lists -------------------------")
  val partitioned = fibList.partition(_ % 2 == 0)
  println(partitioned)

  println("\n\nspan is similar to filter. The main difference ")
  println("is it splits the list at the first element that fails the test----------------------------------------- ")
  val spanned = fibList.span(_ < 5)
  println(spanned)

  println("\n\nslice works the way it normally does -----------------------------------------")
  val sliced = fibList.slice(2, 5)
  println(sliced)

  println("\n\nDrop drops the first n elements-----------------------------------------")
  val dropped = fibList.drop(3)
  println(dropped)

  println("\n\nDropWhile drops until a condition is met-----------------------------------------")
  val dropped2 = fibList.dropWhile(_ < 6)
  println(dropped2)
  val dropFunc: Int => Boolean = x => x < 6
  val dropped3 = fibList.dropWhile(dropFunc) //can use a function that returns a boolean
  println(dropped3)


  //map/apply functions----------------------------------------------------------------
  println()
  println()
  println("Advanced map/apply functions----------------------------------------------------------------")
  println("\n\nfor each is almost the same as map, but forbids side-effects with a required Unit return type---------")
  var forEachFunc: Int => Unit = { x => print(x + " ") }
  fibList.foreach(forEachFunc) //can pass in a first-class function too


  //search functions----------------------------------------------------------------
  println()
  println()
  println("Advanced search functions----------------------------------------------------------------")

  println("\nexists is nearly the same as contains, but takes a conditional, rather than a exact value")
  val existsFunc: Int => Boolean = x => x < 6
  val exists = fibList.exists(_ < 6)
  println(exists)
  val exists2 = fibList.exists(existsFunc) //can use a function that returns a boolean
  println(exists2)

  println("\n\nfind  returns an Option that may or may not have the first element the meets the condition----------------")
  val foundFunc: Int => Boolean = x => x > 6
  val found = fibList.find(_ > 6)
  println(found)
  val found2 = fibList.find(foundFunc) //can use a function that returns a boolean
  println(found2)


  //reduce functions----------------------------------------------------------------
  println()
  println()
  println("Advanced reduce functions----------------------------------------------------------------")

  println("\n\nReduce can handle classes, but the input and output type need to match-------------------------------")
  val reduced2 = sampleList.reduce((a,b)=>SampleA(a.x * b.x, 0))
  println(reduced2)
  println("\n\nThe workaround is to map to the desired item first!-------------------------------")
  val reduced3 = sampleList.map(_.x).reduce(_*_)
  println(reduced3)


  println("\n\nFold is similar, but we can state the starting value!-------------")
  val folded = fibList.fold(-1)(_ * _) //currying
  println(folded)

  //val folded2 = sampleList.fold(-1)((a,b)=>a.x * b.x)
  //val folded2 = sampleList.fold[Sample](-1)((a,b)=>a.x * b.x)
  val folded2 = sampleList.fold[SampleA](SampleA(1,0))((a, b)=>SampleA(a.x * b.x, a.y * b.y))
  println(folded2)


  println("\n\nScan starts with a given value, but keeps a running answer rather than one final result-----------------")
  val scanned = fibList.scan(1)(_ * _)
  println(scanned)

  println("\n\nFoldLeft and FoldRight is similar to fold, -----------------------------------------")
  println("but fold can be done in parallel with no guarantee of order. ")
  println("Left and right ensure left/right associativity (and reduceLeft/Right are similar to reduce in the same manner)")
  println("and scanLeft/Right are similar to scan in the same manner)")
  println("We can also mix input and output data types)")
  var foldFunc: (Int, Int) => Int = (x, y) => x * y
  val foldedL = fibList.foldLeft(1)(foldFunc)
  println(foldedL)
  println(sampleList.foldLeft(1)(_ * _.x)) //1 * Sample(0).x = y...y * Sample(1).x = z


     /*
     QUESTION:
     Using functional programming techniques, sum all the number in a list
     that are evenly divisible by 3


     val result = temp.filter( x=> x%3==0).sum

      */


}


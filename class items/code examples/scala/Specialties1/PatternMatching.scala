package Specialties

//examples of more powerful "switches" in Scala
object PatternMatching extends App {
    //standard switch usage
    val test = 1
    println( test match {
        case 1 => println("One")
        case 2 => println("Two")
    })

    //standard usage, WITH a return and default and OR
    val result = test match {
        case 1 | 2 => "low"
        case 3 => "mid"
        case _ => "unknown"
    }

    println(result)

    println("\nCan actually use an IF in the case clause!")
    val num = 3
    //the syntax is: case varName if condition => contents
    val evenOdd = num match {
        case x if x % 2 == 1 => "odd"
        case _ => "even"
    }
    println(evenOdd)

    println("Can match on sub components")
    val mTuple = Tuple2(0, "a")
    val tupleType = mTuple match {
        case (1, "a") => "Perfect match"
        case x if x._1 == 1 => "Match part 1"
        case x if x._2 == "a" => "Match part 2"
    }
    println(tupleType)

    println("\ncan use it to match to the type!!")
    val value: Any = 2.50f
    //the syntax is: case varName: dataType => contents
    val valueType = value match {
        case price: Int => "Int"
        case price: Float => "Float"
        case price: Double => "Double"
        case price: String => "String"
        case price: Boolean => "Boolean"
        case price: Char => "Char"
        case price: Long => "Long"
    }

    println(valueType)

    //there is no true fall through, but there is a way to fake it
    //this does require partial functions though
    private def firstTask(): Unit = { println("first"); }
    private def secondTask(): Unit = { println("second"); }
    private def thirdTask(): Unit = { println("third (stop)"); }
    private def forthTask(): Unit = { println("fourth (stop)"); }
    //this make a partial function than take in an Int, and returns an Int
    val fakeFallThrough:PartialFunction[Int, Int] = {
        case 1 => firstTask(); 2
        case 2 => secondTask(); 3
        case 3 => thirdTask(); 0
        case 4 => forthTask(); 0

    }

    //the general idea is that you forward to the next case, and end with a case with nothing
    //1 will fall through to 2
    var x = 1
    println("test 1")
    while( x != 0 )
        x = fakeFallThrough(x)

    //3 will not fall through
    x = 3
    println("\ntest 3")
    while( x != 0 )
        x = fakeFallThrough(x)


    
    
    //pattern match to build a list----------------------------------------------------
    def NumToText(givenlist : List[Int]) : List[String] = {
        var newlist= List[String]()

        for(a <- givenlist)
        {

            a match{
                case 0 => newlist:+=a.toString
                case 1 => newlist:+=a.toString
                case 2 => newlist:+=a.toString
                case 3 => newlist:+=a.toString
                case _  => newlist:+="unknown"
            }
        }

        newlist
    }
    val mList = List(-1, 0, 1, 7, 3)
    val newList = NumToText(mList)
    print(newList)
}

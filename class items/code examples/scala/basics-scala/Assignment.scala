package Basic


object Assignment extends App {

    //commenting....identical to Java


    //basic Immutable assignments using val
    val x: Int = 2 // final int x = 2;
    //x = 3 //Immutable, so forbidden
    //val z : Int // immutable so value is needed immediately (C++ const)
    val z = 5 //type inferred as Int

    val z2 : Long = z   //widening coercion supported
    val pi: Double = 3.14159

    val anything : Any = "anything goes!" //Any is similar to Java's Object class
    val temp: Boolean = true

    //coercion
    val shrink: Short = pi.toShort //by the way pi.toShort() FAILS, but toString() works!
    val converted: String = 23.toString

    //This means the variable is “void” aka contains nothing.
    // It doesn't make much sense as a variable, but it is legal
    var void = ()



    /*
    QUESTION: If 23.toString works, what does that imply about the nature of 23 in Scala?






    Answer: 23 is a class!

    It’s primitive/built-ins include
    Short
    Int
    Long
    Boolean (true and false)
    Double
    String
    Byte
    Char
    Unit (similar to void)
    etc

     */



    //basic mutable assignments
    var y: Int = 0
    var e: Double = 2.71828
    y = 9

    //_ means "fill in later"... Think of _ a bit like "null"
    //_ --> wild card
    var stuff: String = _ //string stuff;
    //val stuff2: String = _ //final int stuff2;

    stuff = "teddy bear"
    println("stuff defined later: " + stuff)
    /* QUESTION:
    The above commented out line line will not compile, why?






    ANSWER: val means immutable, and I just told it that I want to update it later!
     */


    //Immutable Lists start here
    //NOTE: Scala [] --> Java/C++ <>   .......
    // Scala () --> Java\C++ [] in most cases
    {
        //use var for mutable assignments
        val list: List[Int] =List[Int ](2) //ArrayList<Integer>
        println("\nList of ints: " + list)

        val list3 = (1, 2, "three") //minus this List, this becomes a tuple!
        println("List of ANY: " + list3)
        //list3._1 // tuples are 1 index, and immutable


        var list4 = List(1, 2)
        println("Element at index x: " + list4(1))
        //list4(1) = 2 //individual elements are immutable
        //list4 = List(0,0,0,0); //ok

        //how to append, NOTE: the : states the object being appending on to.
        //Normally, the collection
        list4 = list4 :+ 3
        list4 = 0 +: list4
        println("appended list: " + list4)
    }

    //Arrays
    {
        //arrays as well, and these are mutable, but need new
        //more on "new" versus no "new" later
        val arr: Array[String] = new Array[String](3)
        arr(0) = "hi"
        arr(1) = "there"
        arr(2) = "!"
        println("\nresult (toString fails): " + arr.toString)

    }

    //more on type inference
    {
        //if you run into a type error, check the type Scala filled in for you!
        //NOTE: it is normally safer to be explicit about the type!
        var list4 = List(1, 2)
        //list4 = list4+:"three" //compile error since list4 is type inferred as an integer list

        //this is legal since is a datatype that fits is inferred
        var anyList = list4 :+"three"

        println("Any datatype list: " + anyList)

        /*
        QUESTION:
        To show the care needed with type inference, consider the following
        which may have unexpected answers.

        What is the data type of anyList?
        What is the datatype of anyList if I use :+ instead of +:?




        Answer:
            Vector[Any]
            List[Any]
         */
    }


}


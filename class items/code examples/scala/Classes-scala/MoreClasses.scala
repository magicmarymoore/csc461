package Classes


//abstract, same as java
abstract class AddPrint {
    def myPrint(): Unit //no abstract keyword needed


    def temp(): Unit = {
        println("Still can use regular functions")
    }
}

//instance stuff goes here
class Square() extends AddPrint {
    protected val width = 1 //protected
    private val height = 0.3 //private

    //no override keyword needed for abstract function
    def myPrint(): Unit = {
        println(s"Width: $width   Height: $height")
    }
}

//class/static goes here
object Square {

    def apply():Square = {
        val temp  =new Square() //can build in parts this way
        temp
    }
}


/*
case class combines object and class sections.

Automatically adds these behind the scenes:
apply(matchClassParamList)
toString()
hashCode()
equals()

There are a few limitations, though
 1) no static methods (can still make static variable with companion object
 2) meaning of "apply" changes
*/
case class MockStruct(kind: String = "Plain", var size: Int = 1) {
    var radius = 1 //left as public for ease of explanation
    val height = 0.3

    def apply(x :Int):MockStruct={ //is an INSTANCE function now!
        size = x
        MockStruct() //this will lose the size = x line
        this //needs this now instead of new MockStruct
    }

    //technically, different return types work in the regular object{} too
    def apply(x :String):Unit={
       println(s"Lack of orthogonality? $x")
    }
    
    def printThis(): Unit = {
        println("This can be printed without an instance of Pancakes")
    }

    ////uncomment to make a custom toString()
//    override def toString: String = {
//        s"$kind-->$size   radius: $radius  height: $height"
//    }

}


object TestIvsS extends App {
    val a = Square()
    a.myPrint()


    val mockStruct = MockStruct("fake", 2)
    val mockStructRepeat = MockStruct("fake", 2)
    val mockStruct2 = MockStruct("stuff")
    //val mockStruct4 = MockStruct(2) //fails since only 1 constructor (the paramList) is permitted
    println(mockStruct)

    //== overridden
    // checks the paramList...NOT the other variables
    mockStruct.radius = 2
    mockStructRepeat.radius = 3
    println("Are the same:" + (mockStruct==mockStructRepeat))
    mockStructRepeat.size = 3
    println("Are the same now:" + (mockStruct==mockStructRepeat))


    println()
    val mockStruct3 = MockStruct()
    var result = mockStruct3(2) //apply is now the () function...
    println(s"Result of using apply() in a case class INSTANCE: $result")
    println(mockStruct3.size)
    
    mockStruct3("yep...") //overloaded apply allow different return types
    

}
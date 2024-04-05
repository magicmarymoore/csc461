package Specialties

//standard getter and setter
class Before() {
    private var x = 0
    private var y = 1

    def getX: Int = {
        x
    }

    def setX(temp : Int) : Unit = {
        x = temp
    }

    def getY: Int =  y

    //setter with a check
    def setY(temp : Int) : Unit = {
        if(temp < 0){
            y =0
            println("Value for Y must be above 0. Set to 0")
        }else {
            y = temp
        }
    }
}


class After() {

    private var x2 = 0 //name your variable something other than what it will be accessed with
    private var _y = 1 //prefacing a _ is the Scala code style standard

    def x: Int = x2 //define a getter function
    def x_=(value: Int): Unit = { //this is the setter function. It needs the appended _
        x2 = value
    }

    //large example with a validity check
    def y: Int =  _y
    def y_=(value: Int): Unit = {
        if(value < 0){
            _y = 0
            println("Value for Y must be above 0. Set to 0")
        }else {
            _y = value
        }
    }
}



object Properties extends App {

    val before = new Before
    before.setX(1)
    before.setY(-3)
    println(s"Before: x=${before.getX} y=${before.getY}")


    println()
    val after = new After
    after.x = 2     //usage like a public variable
    after.y = -3    //acts like a getter/setter!
    after.y = 3
    println(s"After: x=${after.x} y=${after.y}")

}



//Question: Make your own properties for a normalized vector in a
// 3 dimensional vector (the math kind).
// In other words, fix an unnormalized vector if needed in the "setter"
// Return it as a tuple in the "getter"




//ANSWER:
case class nVector() {
    private var _vec = Tuple3(1.0, 0.0, 0.0)

    def Vec: Tuple3[Double, Double, Double] = _vec //define a getter function

    def Vec_=(value: Tuple3[Double, Double, Double]): Unit = { //this is the setter function. It needs the appended _
        val length = Math.sqrt(value._1 * value._1 + value._2 * value._2 + value._3 * value._3)
        _vec = (value._1 / length, value._2 / length, value._3 / length)
    }
}
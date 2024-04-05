package Specialties

object Currying extends App {
    def addOriginal(x: Int, y: Int, z: Int) = {
        x + y + z
    }

    def addCurry(x: Int)(y: Int)(z: Int) = {
        x + y + z
    }

    val a = addOriginal(1, 2, 3)
    val b = addCurry(1)(2)(3)

    println("At first, it seem like currying is just " +
        "chaining the syntax for making/calling a function")
    println(s"a = $a   b = $b")

    println("The advantage come when we see the first class functions")
    val curry1 = addCurry(1) _
    val curry2 = addCurry(1)(2) _

    println("If we don't give ALL the parameters, it returns a" +
        " function with the parameters that were given saved")
    println(s"saved 1: ${curry1(3)(3)}")
    println(s"saved 2a: ${curry2(10)}")
    println(s"saved 2b: ${curry2(5)}")


    //QUESTION: What will this print:
    val curry3 = addCurry(5)(2) _
    println(s"Practice 3: ${curry3(3)}")




    //curry a curry!
    val curry4 = curry1(2) (_)
    println(s"saved 4: ${curry4(20)}")


}

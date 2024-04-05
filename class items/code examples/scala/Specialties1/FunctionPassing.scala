package Specialties

object FunctionPassing extends App{



  //------------Basic Function passing--------------------------------------------------------------------------------------
  {
    println("\n\n\n------------Function passing--------")

    //first class function
    //define a function parameter with
    //  name : ([type1, ...]) => return type
    def userMath(x: Int, y: Int, f: (Int, Int) => Int) = {
      f(x, y)
    }

    def mySub(x: Int, y: Int) = {
      x - y
    }

    def myPlus(x: Int, y: Int) = {
      x + y
    }

    println(s"Pass the subtraction function with 3 and 4: ${userMath(3, 4, mySub)}")
    println(s"Pass the addition function  with 3 and 4: ${userMath(3, 4, myPlus)}")
  }





  //------------Lambda--------------------------------------------------------------------------------------
  println("\n\n\n------------Lambda--------")

  //lambdas can get pretty crazy with the syntax
  //full form:
  // val funcName : (type, type,...) => returnType = {the function contents}
  // OR
  // val funcName = (param: type, param:type,...) => {the function contents}
  // OR
  // def funcName = (param: type, param:type,...) => {the function contents}
  private val lambda1 : (Int, Double) => Double = _ / _ //filled in the same order given
  private val lambda2 = (x: Int, y: Double) => x / y //type inference makes the syntax inconsistent
  private def lambda3  = (x: Int, y: Double) => x / y //def works too...

  println(s"lambda1: ${lambda1(3, 4)}")
  println(s"lambda2: ${lambda2(3, 4)}")
  println(s"lambda3: ${lambda3(3, 4)}")



  //-----Closure------------------------------------------------------------------------------------
  {
    def makeFunc(level: Int, offset: Int = 0) = {
      val f = (x: Double) => {
        x * 1 + offset
      }

      val f2 = (x: Double) => {
        x * 2 + offset
      }

      level match {
        case 1 => f
        case 2 => f2
        //lambda version
        case 3 => (x: Double) => { x * 3 + offset}
        case _ => f
      }

    }

    println(s"Make a function: ${makeFunc(1)(2)}")
    println(s"Make a function: ${makeFunc(2, 2)(2)}")
    println(s"Make a function: ${makeFunc(3)(2)}")

    //QUESTION: What would this return;
    //makeFunc(3, 4)(2)









    //ANSWER: 10
    val closureFunc = makeFunc(3, 4)
    println(s"\n\n\n\n\n\nMake a function with offset: ${closureFunc(2)}")
  }


}

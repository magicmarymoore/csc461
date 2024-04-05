package Specialties

import scala.annotation.targetName

case class MathVector(x: Int, y: Int){
  override def toString(): String = {
    "("+x + ", " + y + ")"
  }

  @targetName("add")
  def +(that:MathVector) : MathVector ={
    MathVector(this.x + that.x, this.y + that.y)
  }

  @targetName("subtract")
  def -(x:MathVector): MathVector ={
    val nexX = this.x - x.x
    val nexY = this.y - x.y

    MathVector(nexX, nexY)
  }

  def dot(x:MathVector): Int ={
    val nexX = this.x * x.x
    val nexY = this.y * x.y
    nexX + nexY
  }

  @targetName("negate")
  def unary_- ={
    MathVector(-this.x, -this.y)
  }
}

object OperatorOverload extends App{

  val a = MathVector(1,1)
  val b = MathVector(2,2)
  val c = a + b
  println(s"$a + $b = $c")
  println(s"$a - $b = ${a - b}")
  println(s"-$a = ${-a}")
  println(s"$a dotted $b = ${a dot b}")

}

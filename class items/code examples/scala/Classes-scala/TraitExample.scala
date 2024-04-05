package Classes


/*

traits are interfaces...with all the power of an abstract class
but are not inherited from object so no risk of inheritance collision


Basic syntax:
trait traitName(OptionalParameter)
{
	def func1(…) : datatype
	def func2(…) : dataType
	…
}

To use
class className extends TraitOrClass
class className extends TraitOrClass with Trait
class className extends TraitOrClass with Trait with Trait ...

Only one class is permitted, but numerous traits

 */


trait BasicMath {
  var count = 0 //instance variable

  //default function
  def add(right: (Double, Double, Double)): (Double, Double, Double) = {
    count = count + 1
    (0, 0, 0)
  }

  //pure abstract
  def sub(right: (Double, Double, Double)): (Double, Double, Double)

  def mult(left: (Double, Double, Double), right: (Double, Double, Double)): Double = {
    //tuples have weird indexing, more on this later
      left._1 * right._1 +
      left._2 * right._2 +
      left._3 * right._3
  }
}

//even companion objects!
object BasicMath {
  var stillHasStatic = 1 //static variable
}

//if only one parent class or trait, use extends
class Vector(x: Double = 0, y: Double = 0, z: Double = 0) extends BasicMath {

  override def add(right: (Double, Double, Double)): (Double, Double, Double) = {
    super.add(right)
    (x + right._1,
      y + right._2,
      z + right._3)
  }

  override def sub(right: (Double, Double, Double)): (Double, Double, Double) = {
    (x - right._1,
      y - right._2,
      z - right._3)
  }

}


//Multiple ------------------------------------------------------------------------
trait A {
  def foo(): Unit = println("foo_A")
}

trait B extends A {
  override def foo(): Unit = {
    println("foo_B")
  }
}

trait C {
  def foo(): Unit = println("foo_C")
}


//if more than one class/trait, class goes first (if applicable), then the traits.
class Multiple extends B with A {
  override def foo(): Unit = {
    println("foo multiple")
  }
}


// oddly OK, as long as I override foo.
// no name conflict here since we said "use this foo"
class D extends A with B with C {
  override def foo(): Unit = {
    super.foo() //cannot explicitly pick super class
    println("foo_D")
  }
}

/*
What on earth is going on?

When we have multiple classes/traits Scala/JVM loads them in one at a time,
in an inheritance “stack” (no true multiple inheritance here!).
Setup properly, you can hit every foo() on the stack!


Stack:
A
B
C
D

 */


object TestTraits extends App {

  val a = new Vector(1, 2, 3)
  println(s"A's count before: ${a.count}")

  println()
  val b = a.add((1, 1, 1))
  println(s"Vector (1,2,3) + (1,1,1): $b")
  println(s"A's count after: ${a.count}")

  println()
  val c = a.sub((1, 1, 1))
  println(s"Vector (1,2,3) - (1,1,1): $c")

  println()
  val d = a.mult((1, 2, 3), (1, 1, 1))
  println(s"Vector (1,2,3) dot (1,1,1): $d")

  println("Static: " + BasicMath.stillHasStatic)
  //Vector.stillHasStatic /// but it doesn't belong to the derived class

  //--------------------------------------------------------------------------
  println("\nFoo with overridden call")
  val e = new Multiple()
  e.foo()


  println("\nFoo with super call")
  val f = new D()
  f.foo()


}

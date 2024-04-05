package Specialties


class Top{
  override def toString : String = "Top";
}

//normal inheritance
class Mid extends Top{
  override def toString : String = "Mid";
}

//normal inheritance
//makes this like a generic(Java) or template (C++)
class Bottom[A] (x: A) extends Mid{
  override def toString : String = "Bottom_A";
}

//multiple types are permitted
class BottomVary[A, B] (x: A,  z:B) extends Mid{
  override def toString : String = "Bottom_AB";
}

// invariant
//should only work with new Mid(...), but x can be anything Mid or derived
class restrict[A <: Mid](x: A)  {
  override def toString : String = "restrict";
}

//should only work with Mid AND the new object must be Mid, or a derived class (covariance)
class restrictAnc[+A <: Mid](x: A) {
  override def toString : String = "restrictAnd";
}

//should only work with Mid AND the new object must must be Mid, or a parent class (contravariance)
class restrictChild[-A <: Mid](x: A) {
  override def toString : String = "restrictChild";
}


object Typing extends App {
  //basic restrictions ---------------------------------------------
  val a = new Bottom[Int](3)
  println(a)
  //will fail due to a mismatch
  //val a2 = new Bottom[Int](1,2,"three")
  //println(a2)
  
  val b = new BottomVary[Int, String](1,"three")
  println(b)
  //will fail due to a mismatch
  //val b = new BottomVary[Int, String](1,2,3)
  //println(b)

  //invariant
  val c = new restrict[Mid](new Bottom[Int]( 1))
  val c2 = new restrict[Mid](new Mid())
  //val c3 = new restrict[Mid](new Top()) //fails like normal since Top is an ancestor
  val c4 = new restrict[Bottom[Int]](new Bottom[Int]( 1))

  //looks normal until...
  //val c5 = new restrict[Int](1)                   //no warning, but fails since the base type is not Mid  or a child
  //val c6 = new restrict[Top](new Mid( ))           //no warning, fails since the base type is not Mid or a child
  val c7 : restrict[Mid] = new restrict[Mid](new Mid()) //ok
  val c8 : restrict[Mid] = new restrict[Mid](new Bottom[Int](1) )
  //val c9 : restrict[Mid] = new restrict[Bottom[Int]](new Bottom[Int](1))   //fails, since restrict type isn't match



  //Scala also allows for more control over what a class can be set to with type classes, these fail with basic typing
  //val d1 = new restrictAnc[Int](1)                     //no warning, fails since the base type is not Mid  or a child
  //val d2 : restrictAnc[Top] = new restrictAnc[Top](new Bottom[Int]( 1))                 //no warning, but fails
  val d3 : restrictAnc[Bottom[Int]] = new restrictAnc[Bottom[Int]](new Bottom[Int]( 1)) //allows at level or down
  val d4 : restrictAnc[Mid] = new restrictAnc[Bottom[Int]](new Bottom[Int]( 1))



  //Scala also allows for more control over what a class can be set to with type classes, these fail with basic typing
  //val e1 = new restrictChild[Int](1)                                                //no warning, but fails
  val e2 : restrictChild[Mid] = new restrictChild[Mid](new Mid( ))                    //allows at level or up
  val e3 : restrictChild[Bottom[Int]] = new restrictChild[Mid](new Bottom[Int]( 1))   //clamped to Mid
  //val e4 : restrictChild[Bottom[Int]] = new restrictChild[Mid](new Top( ))          //clamped to Mid so this doesn't work
  //val e5 : restrictChild[Mid] = new restrictChild[Bottom[Int]](new Bottom[Int]( 1)) //fails


}
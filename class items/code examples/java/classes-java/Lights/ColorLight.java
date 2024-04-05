package classes.Lights;

public class ColorLight extends Lightbulb {
    private String color = "white";

    public String getColor() {
        return color;
    }

    public ColorLight(String color) {
        this(color, 20); //forward construction
    }

    public ColorLight(String color, double lifetime) {
        super(lifetime); //must be on first line, and super refers to the parent
        this.color = color;
        System.out.println("Color light");
    }

    //put this in and it will fail.
    //Why? HINT: check the base class
    //public ColorLight(){}

    @Override
    public void turnOn(double time) {
        super.turnOn(time); //EXTEND the parent's functionality
        if (isAlive()) {
            System.out.print("Still alive: ");
        } else {
            System.out.print("Dead: ");
        }
    }

    public String toString() {
        return "The color is " + color + ". " + super.toString();
    }

}

/*
QUESTION:
Assume we have this:
-----------------------------------
class A{
   int var = 0;
   public void print(){
		System.out.print(var);
   }
}
class B extends A{}
class C extends A{}
---------------------------------

What is the best way to make B print 2, and C print 3 with print()?
Add a constructor like
1) Call the super constructor with a numeric literal
      B() {super(2);}
      C() {super(3);}

2) Override print() in B and C

3) Add a static variable in B and C, and use a constructor like
		private static final int temp  = 2;
		B() {super(temp);}

		private static final int temp  = 3;
		C() {super(temp);}
----------------------------------------------------------






Answer:
C
A may work, but those are constants, so C is better.

B is special casing things you do not want to special case.
 */

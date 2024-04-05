package VisitorExample;

public class Cattle extends Animal{
    public Cattle(boolean male) {
        super(male);
    }

    @Override
    public void accept(Visitor v) {
        v.gotACattle(this);
    }

    public boolean isBull(){
        return gender;
    }

    @Override
    public String toString(){
        return "Cattle: " + (gender ? "bull" : "cow");
    }

}

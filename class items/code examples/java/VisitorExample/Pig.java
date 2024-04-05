package VisitorExample;

public class Pig extends Animal{


    public Pig(boolean male) {
        super(male);
    }

    @Override
    public void accept(Visitor v) {
        v.gotAPig(this);
    }

    public boolean isBoar(){
        return gender;
    }

    @Override
    public String toString(){
        return "Pig: " + (gender ? "boar" : "sow");
    }


}

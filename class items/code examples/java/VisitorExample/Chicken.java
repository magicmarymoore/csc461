package VisitorExample;

public class Chicken extends Animal{
    public Chicken(boolean male) {
        super(male);
    }

    @Override
    public void accept(Visitor v) {
        v.gotAChicken(this);
    }

    public boolean isRooster(){
        return gender;
    }

    @Override
    public String toString(){
        return "Chicken: " + (gender ? "rooster" : "hen");
    }
}

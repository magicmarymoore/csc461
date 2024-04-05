package VisitorExample;

public abstract class Animal {
    protected boolean gender = false;

    public Animal(boolean male){
        this.gender = male;
    }

    public abstract void accept(Visitor v);
}

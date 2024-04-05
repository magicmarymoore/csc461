package classes.mulitpleInheritance;


public abstract class Top {

    public void sayHi(){
        System.out.println("Hi in Top");
    }

    //final forbids overriding
    public final void sayBye(){
        System.out.println("Bye in Top");
    }

    public abstract void makeMeLater();
}

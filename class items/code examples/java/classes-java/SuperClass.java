package classes;

public class SuperClass
{
    public SuperClass()
    {
        System.out.println(
                "Classes.SuperClass constructor" );
    }
    
    public void printHello() {
        System.out.println(
                "Hello from Classes.SuperClass" );
    }

    public void printHelloOverwrite() {
        System.out.println(
                "Hello from Overwriteing Classes.SuperClass" );
    }

}

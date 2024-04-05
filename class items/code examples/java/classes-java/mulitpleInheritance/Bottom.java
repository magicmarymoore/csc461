package classes.mulitpleInheritance;


//final here stops extension of the class
public final class Bottom extends Top implements CreateNum, GameTurn{

    /*
    Refresher:
      --You cannot create an instance of an abstract Class
      --You cannot use private or final with an abstract method
     */


    private int turn = 0;

    public double newNumber(int num){
        System.out.println("Multiplied by 1.5");
        return num * MORE;
    }
    @Override
    public  int nextTurn(int turn)
    {
        return 1;
    }

    public void makeMeLater(){
        System.out.println("Finished makeMeHere in Bottom ");
    }


}

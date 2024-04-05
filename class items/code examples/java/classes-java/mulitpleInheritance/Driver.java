package classes.mulitpleInheritance;

import classes.Date;

/**
 * Created by LisaR on 12/4/2015.
 */
public class Driver {
    public static void main(String[] args) {
        Bottom b = new Bottom();
        int f = b.MAX_PLAYER;

        int turn = 0;

        System.out.println("newNumber(): " +b.newNumber(2));
        b.makeMeLater();
        b.sayHi();
        b.sayBye();

        for(int i = 0; i < 5; i++) {
            System.out.println("Turn: " + turn);
            turn = b.nextTurn(turn);
        }
    }
}


package classes.mulitpleInheritance;

public interface GameTurn {
    //"public static final" implied
    int MAX_PLAYER = 3;

    //"public" implied
    //no access to non-final instance variables
    //solvable with the strategy pattern (more on this later)
    default int nextTurn(int turn)
    {
        return (turn + 1) % MAX_PLAYER;
    }
}

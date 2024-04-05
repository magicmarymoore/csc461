public class scratch {

    public int x = 2;
    public static int y = 2;

    public scratch(int z) {
        x = z;
    }

    public void foo(int a) {
        y = 1 + a;
        x = x + y;
    }
}

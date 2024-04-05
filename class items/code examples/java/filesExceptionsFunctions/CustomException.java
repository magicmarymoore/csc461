package filesExceptionsFunctions;

public class CustomException {
    static class IsNegative extends Exception {
        public IsNegative() {
            super();
        }
    }

    static class IsNegative2 extends RuntimeException {
        public IsNegative2() {
            super();
        }


    }


    public static void test(int x) throws IsNegative {
        if(x<0)
            throw new IsNegative();
    }

    public static void test2(int x) {
        if(x<0)
            throw new IsNegative2();
    }

    public static void main(String[] args) {
        try{
            //try these one at a time
            test(-1);
            //test2(-2);
        }catch (IsNegative e){
            System.out.println(e);
        }
        catch (IsNegative2 e){
            System.out.println(e);
        }
    }

}

package exampleIterator;


public class ForEach {

    public static void main(String[] args) {
        ExampleIterator list = new ExampleIterator();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for (Integer x : list) {
            System.out.println(x);
        }
    }
}

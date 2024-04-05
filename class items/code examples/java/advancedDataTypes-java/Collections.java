package advancedDataTypes;

import java.util.*;

/*
Java Collections API (in java.util) resembles the C++ STL
Can’t work with primitives though (wrappers have auto unboxing,
so it looks like it does)
 */
public class Collections
{
    public static void main( String[] args ) {
        // get n
        int n = 16;

        // ArrayList is considered preferable to old Vector class
        // ArrayList vector = new ArrayList();            // compiles with warnings
        ArrayList<Object> vector = new ArrayList<>();     // use of generics allows compile-time type checking

        // stuff some values inside the ArrayList (any Object type is OK)
        for (int i = 0; i < n; i++)
            vector.add(i * 3);

        //all collections have a iterator, which also permits a for-each loop
        {
            // print them out using iterator
            System.out.print("for loop vector:");
            for (Iterator i = vector.iterator(); i.hasNext(); )
                System.out.print(" " + i.next());
            System.out.println();

            // foreach loop is simpler (syntactic sugar, with less power)
            System.out.print("for each vector:");
            for (Object elem : vector)
                System.out.print(" " + elem);
            System.out.println();
        }


        // doubly-linked list example, with sorting!
        {
            List<Integer> list = new LinkedList<>();

            // stuff some values inside the List
            for (int i = 0; i < n; i++)
                list.add((int) (Math.random() * 100));

            // print them out using iterator
            System.out.print("linked list: ");
            for (Iterator<Integer> i = list.iterator(); i.hasNext(); )
                System.out.print(" " + i.next());
            System.out.println();

            //with index
            //warning is that it wants the type to be explicit: ListIterator<Integer>
            System.out.print("linked list with indexed iterator: ");
            for (ListIterator i = list.listIterator(); i.hasNext(); )
                System.out.print(" " + i.nextIndex() + "-->" + i.next());
            System.out.println();


            /*Will do a descending sort
            ......
            Yes, I just made a new class (comparator) within a function!
                 Welcome to Java!
            I intentionally did NOT convert to a lambda (will discus them later)
             */
            list.sort(new Comparator<>() {
                public int compare(Integer lhs, Integer rhs) {
                    return rhs - lhs;
                }
            });

            //OR
            list.sort(new DescendSort());


            System.out.println("\nReverse Sorted:");
            for (int i = 0; i < 10; i++) {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    public static class DescendSort implements Comparator<Integer> {

        @Override
        public int compare(Integer lhs, Integer rhs)
        {
            return rhs - lhs;
        }
    }
}

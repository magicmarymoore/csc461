package exampleIterator;

import java.util.Iterator;

//this Iterable interface marks the class as being able to be in a foreach loop
//and the data type it returns is an Integer
//in  C++, regular, the loop may look like this
// Iterator iter;
//for ( iter.begin(); iter.hasNext(); iter.next()){
//       val = iter.get()
//}
public class ExampleIterator implements Iterable<Integer>  {

    //the storage class
    //This is the base collection teh iterator will work on
    private final int[] list = new int[10];
    private int size = 0;

    //this class controls the foreach loop's "iteration"

    public  class MyIterator implements Iterator<Integer> {
        private int index = -1;

        @Override
        /**
         * The end()/hasNext()
         */
        public boolean hasNext() {
            return index < size - 1;
        }

        @Override
        /**
         * get() and next() are combined
         */
        public Integer next() {
            index++;
            return list[index];
        }
    }

    //just a method to add stuff to the collection
    public void add(int x){
        if(size < list.length) {
            list[size] = x;
            size++;
        }
        else
            System.out.println("No more room in list");
    }

    @Override
    /**
     * the "begin()" in the iterator
     */
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }
}

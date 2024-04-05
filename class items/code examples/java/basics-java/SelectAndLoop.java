package basics;

import java.util.ArrayList;
import java.util.Scanner;

public class SelectAndLoop {

    public static void main(String[] args) {
        //ifs
        {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a int: ");
            int num = in.nextInt();
            if (num < 0) {
                System.out.println("Number is negative");
            } else if (num < 10) {
                System.out.println("Number is between 0 and 10");
            } else {
                System.out.println("Number is over 10");
            }
        }

        //switch
        {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter a letter: ");
            //no nextChar option.
            char letter = in.next().charAt(0);

            //all primitives have a matching "class" with helpers
            letter = Character.toUpperCase(letter);

            //switch works with primitives, string, enums, and number wrappers
            switch (letter) {
                case 'A', 'B':
                    System.out.println("Got an A or B");
                    break;
                case 'C':
                    System.out.println("Got an C");
                    break;
                default:
                    System.out.println("Not an A, B, or C");
                    break;
            }

            //new switch, with no break needed
            switch (letter) {
                case 'A', 'E', 'I', 'O', 'U' -> {
                    System.out.println("Got an vowel");
                    System.out.println();
                }
                default -> System.out.println("Not an (always) vowel");
            }
        }

        //basic while
        {
            int size = 10;
            String[] temp = new String[size];
            int x = 0;
            while (x < size) {
                //Java random
                //random --> [0,1)
                int i = (int) (Math.random() * 5);

                switch (i) {
                    case 0 -> temp[x] = "Zero";
                    case 1 -> temp[x] = "One";
                    case 2 -> temp[x] = "Two";
                    case 3 -> temp[x] = "Three";
                    case 4 -> temp[x] = "Four";
                }
                x++;
            }

            x = 0;
            while (x < size) {
                System.out.println(temp[x]);
                x++;
            }
        }

        //basic for loop, and for each loop
        {
            int size = 10;

            //ArrayList --> c++ vector
            //only accepts reference objects inside of <>, no primitives
            //note size is it CAPACITY, not its # of elements
            // NOTE empty <>
            ArrayList<Integer> list = new ArrayList<>(size);

            //basic for loop identical to C++
            for (int i = 0; i < size; i++) {
                list.add((int) (Math.random() * 100));
            }


            //for each loop
            //can handle any collection that has an iterable interace (more on this later)

            for (int i : list) {
                if (i < 50) {
                    System.out.print("Small: ");
                    System.out.println(i);
                } else {
                    System.out.print("Large: ");
                    System.out.println(i);
                }
            }

            //WARNING:
            //Do NOT edit the list inside a for each loop!
            //It WILL crash
            /*

            //BAD!!!!
            for (int i : list)
            {
                //remove evens
                if( i % 2 == 0)
                    list.remove(i);
            }


           // So how?
           // 1) Make a temporary list and add what you want to delete to that list.
           // 2) Then delete the items that are in that list from the original list.





            // Answer
           */
            //search, and record
            ArrayList<Integer> remove = new ArrayList<>();
            for (int p : list) {
                if (p % 2 == 0)
                    remove.add(p);
            }

            //delete...WARNING: there is a "gotcha" here
            //while "int p" is legal syntax, it looks for the index.
            // Integer looks for the value.
            for (Integer p : remove) {
                list.remove(p);
            }
        }

    }

}


package filesExceptionsFunctions;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileOpening {

    public static void main(String[] args) {
        Scanner file = null;
        String temp = null;

        //by default, IntelliJ searches for files at the same level as scr
        // TIP: to learn where a system start, create a file called
        // FINDME.txt, then search the file system
        String basePath = "src//filesExceptionsFunctions//";

        //C++ style way to open a file
        {

            //see what happens if there isn't a try catch here!
            //Why?
            try {
                //paths.get returns a path object
                file = new Scanner(Paths.get(basePath+"myFile1.txt"));///e.g. ifstream.open
                System.out.println("Lines in file 1: ");
                while (file.hasNext()) {
                    System.out.println(file.nextLine());
                }

            } catch (IOException e) {
                System.out.println("Well, that was not supposed to happen."
                        + " Try a different file?");
            }      //see what happens if there isn't a try catch here!

            //close if it opened properly
            //will fail in earlier versions without this check, and some other compilers
            if (file != null) {
                file.close();
            }
        }
         /*
        Question:
        Now how do we know what exception could happen?
        AKA, without alt+Enter, how do we know we need an IOException?
        Go to https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Scanner.html
        to find out!







        Answer:
        There is a "throws" subheading that will
        list all exceptions that a method can throw

         */

        //Better: auto close the file when done
        {
            try {
                file = new Scanner(Paths.get(basePath+"myFile2.txt"));
                System.out.println("\nLines in file 2: ");
                while (file.hasNext()) {
                    System.out.println(file.nextLine());
                }

            } catch (IOException e) {
                System.out.println("Well, that was not supposed to happen."
                        + " Try a different file?");
            } finally {
                //will fail in earlier versions without this check, and some other compilers
                if (file != null) {
                    file.close();
                }
            }
        }

        //Best: automatically closes the object
        //relative path now
        {
            try (Scanner file2 = new Scanner(Paths.get(basePath+"myFile3.txt"))) {
                System.out.println("\nLines in file 3: ");
                while (file2.hasNext()) {
                    System.out.println(file2.nextLine());
                }
            } catch (IOException e) {
                System.out.println("Well, that was not supposed to happen."
                        + " Try a different file?");
            }

            //Best: automatically closes the object
            //this is similar to ofsteam.open
            try (PrintWriter write = new PrintWriter(basePath+"output2.txt")) {
                System.out.println("outputting stuff");
                write.write("Stuff\n");
                write.print(123);
                write.println("");
                write.write("abcdefghijklmiop", 3, 3);
            } catch (IOException e) {
                System.out.println("Well, that was not supposed to happen."
                        + " Try a different file?");
            }

        }

    }
}


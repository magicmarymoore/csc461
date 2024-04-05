package filesExceptionsFunctions;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;


public class FileDirectoryExample {

    /*
       Gotchas:
       1) 'Paths' check your folder structure and returns a Path
           Paths.get(…) is about all it does!
       2) A 'Path' object is used in file management (marks a location)
       3) A 'Files' object does the file management
       4) There is BOTH a File and Files class.
           Files is newer, and preferred. It also have more functionality
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int input;
        String name = "";
        do {
            System.out.println("Please enter what you want to do:\n" +
                    "1) Open/create a file\n" +
                    "2) Write \"stuff\" a file\n" +
                    "3) Erase file\n" +
                    "4) display files in current directory\n" +
                    "0) quit");
            input = -1;

            try {
                input = Integer.parseInt(in.nextLine());

                switch (input) {

                    case 1:
                        //open a file
                    {
                        System.out.println("Please enter a file name (no spaces):");
                        name = in.nextLine();
                        try {
                            //check if files exists, and made it if it does not
                            //NOTE: FileS, not File
                            if (!Files.exists(Paths.get(name))) {
                                Files.createFile(Paths.get(name));
                                System.out.println("Making file");
                            }

                            //read in every line from the file
                            //list is parent class of ArrayList, and works similarly
                            List<String> lines = Files.readAllLines(Paths.get(name));

                            //close file for reading, but open for writing
                            System.out.println("File Contents");
                            for (String line : lines) {
                                System.out.println(line);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                    case 2:
                        //write to a file
                    {
                        System.out.println("Please enter a file name (no spaces):");
                        name = in.nextLine();
                        Path path = Paths.get(name);
                        byte[] bytes = "Stuff".getBytes();
                        try {
                            if (Files.exists(path))
                                Files.write(path, bytes, StandardOpenOption.APPEND);
                            else
                                System.out.println("file does not exist");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                    case 3:
                        //delete a file
                    {
                        System.out.println("Please enter a file name (no spaces):");
                        name = in.nextLine();
                        try {
                            Files.deleteIfExists(Paths.get(name));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                    case 4:
                        //directory information
                    {
                        //this is a stream, so you can only walkthrough once
                        try (DirectoryStream<Path> directory = Files.newDirectoryStream(Paths.get("."))) {
                            for (Path p : directory) {
                                if (Files.isRegularFile(p)) {
                                    System.out.println(p);
                                }
                            }
                        } catch (IOException e) {
                            System.err.println("An IO Exception occurred");
                        }
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number");
            }
        } while (input != 0);


    }

}
/*
Questions:
* What class(es) should we use delete a file?
* What class(es) should we use to handle a file address?
* What class(es) should we use to edit a file contents?
* What class(es) should we use to edit a file attributes?












Answers:
* Files
* Path
* Scanner/print writer/etc
* Files


 */

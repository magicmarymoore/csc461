package filesExceptionsFunctions;

import java.io.*;

//This is only for the curious
//this is how file reading was done in the past (and some specialty files now)
//Java let you decide on the exact parsing filters. The problem was
//that this was identical 90% of the time!
public class DataInputBuilder {
    public static void main(String[] args) {
        //old method to open a file...
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new DataInputStream(
                                new FileInputStream("src//filesExceptionsFunctions/myFile1.txt"))))) {
            System.out.println ("first line: " + in.readLine());

        } catch (FileNotFoundException e) {
            System.err.println("The file was not found");
        } catch (IOException e) {
            System.err.println("An IO Exception occurred");
        }


    }
}

package filesExceptionsFunctions;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;

public class AppendingFiles {
    public static void main(String[] args) {

        String temp = null;

        //by default, IntelliJ searches for files at the same level as scr
        String basePath = "src//filesExceptionsFunctions//";

        //Print writer does not have the flag for append
        //need java style build up!
        try (FileWriter file = new FileWriter(basePath + "appendTimes.txt", true)) {
            BufferedWriter fout = new BufferedWriter(file);
            //PrintWriter out = new PrintWriter(fout)); //could get all the way to PrintWriter if desired

            //params: text, starting index into text, length of test to output
            fout.write(LocalDateTime.now().toString() + "\n", 0, LocalDateTime.now().toString().length()+1);
            fout.flush();
            //more code
        } catch (IOException e) {
            System.out.println("Try a different file?");
        }


        //this is probably the closest in power!
        //rw for read-write, and r for just read
        try (RandomAccessFile file = new RandomAccessFile(basePath + "appendTimes.txt", "rw");) {

            long length = file.length();
            file.seek(length - 10); //put us around the . in the date
            System.out.println("seconds: "+file.readLine());
            long location = file.getFilePointer();
            file.seek(location - 11);
            file.writeByte('s');
            //more code
        } catch (IOException e) {
            System.out.println("Try a different file?");
        }
    }
}

package FileAndFunctions

import java.io.{FileNotFoundException, FileWriter, IOException}
import scala.io.{BufferedSource, Source}

object FileExample extends App {

    private val filename = "test.txt"
    private var file: BufferedSource = _ //yep not a File type!

    //make sure the SCALA version was imported, not the Java version
    {
        println("Basic file open")
        file = Source.fromFile(filename) //returns a buffered source
        val fileLines = file.getLines() //returns an iterator
        for (line <- fileLines) {
            println(line)
        }
        println("\n\nThe file is now used up, since the iterator hit the end.")
        val willBeEmpty = file.getLines()
        println(s"Called getLines again, a second time. \nContents: ${willBeEmpty.length}")
        println(".....................")
        file.close
    }



    //ASIDE, if you want random access use
    // File.getLines().toList
    // OR
    // File.getLines().toArray



    //file slices
    {
        println("\n\nSlices works on Scala iterators! As do standard iterator methods")
        val file2 = Source.fromFile(filename) //returns a buffered source
        val fileLines2 = file2.getLines() //returns an iterator
        print(s"Getting just the 3rd to 4th line: ")
        val sliced = fileLines2.slice(2, 4)
        while (sliced.hasNext) //using iterator syntax here rather than for-each for clarity
            print(sliced.next() + ", ")
        file2.close

        println("\n\nIf you want to save the information for repeated reference, you need" +
          " to convert")
        val file3 = Source.fromFile(filename) //returns a buffered source
        val fileLines3 = file3.getLines() //returns an iterator
        //mkString is similar to ", ".join(collection) from python
        println(s"As an array: \n[${fileLines3.toArray.mkString(", ")}]")
        file3.close
    }


    //better read with try-catch
    {
        println("\n\nIt is better to wrap the file in a try-catch block to automatucally close")
        try {
            val file = Source.fromFile(filename) //returns a buffered source
            val fileLines = file.getLines() //returns an iterator
            while (fileLines.hasNext) { //hasNext also works
                println(fileLines.next())
            }
        } catch {
            //yep, use JAVA's exceptions here
            case e: FileNotFoundException => println("Couldn't find that file.")
            case e: IOException => println("Got an IOException!")
        }
        finally {
            file.close
        }
    }





    //output--------------------------------------
    {
        println("\n\nIronically, Scala uses Java write file libraries rather than rewrite there own!")
        val path = "testOut.txt"
        //why FileWriter rather than PrintWriter? File uses exceptions, Print uses flags
        val write = new FileWriter(path)
        try {
            write.write("Stuff\n")
            write.write("Stuff2")
        } catch {
            case e: IOException =>
                println("Well, that was not supposed to happen." + " Try a different file?")
        } finally
            write.close()

        //QUESTION:
        // Write code to open a file named “test.txt”
        // and print up to the first three lines (if available) to
        // a new file named “out.txt”


        /* ANSWER
        val filename2 = "test.txt"
        val fileA = Source.fromFile(filename2) //returns a buffered source
        val fileLinesA = fileA.getLines() //returns an iterator
        val write2 = new FileWriter("out.txt")
        val lines2 = fileLinesA.slice(0,3)
        for(x <- lines2){
            write2.write(x+"\n")
        }
        write2.close()
         */


    }


}

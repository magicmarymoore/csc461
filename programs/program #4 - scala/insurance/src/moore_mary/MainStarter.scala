package moore_mary

import java.io.FileWriter
import java.text.DecimalFormat
import scala.io.StdIn
import scala.xml.XML
import scala.collection.parallel.CollectionConverters._


/*
Every Line with a * has its grading tag (if reached):       X

0. Got it running	6			                                    X

1.	Add + Display*	36
Prompts correct 				                                    X
Adds each item 					                                    X
Above displays correctly formatted 		                      X


2A) Remove + Display*	10
Prompts correct					                                    X
Removes and displays correctly 			                        X


2B) Add + XML save*	14
Console added items saved correctly 		                    X
Console added multiples is saved correctly 	                X


2C) XML load + XML save*	14
1 XML file loaded and saved correctly 		                  X
2+ XML file loaded and saved correctly		                  X


2D) XML load + Display*	12
1 XML file loaded and displays correctly 	                  X
2+ XML file loaded and displays correctly	                  X


2E) XML+ Display with bad file handing	10
All errors handled 				                                  X?? see note below


3.	Stress test for above*	12
Loads in file, adds data, and displays/saves correctly		  X
Appends a file and displays/saves correctly 			          X
Removes elements after edits, and displays/saves correctly 	X


4. Find cars*	9
RDP format at least there				                            X
Lists cars						                                      X
Formatting						                                      X
Handles “not found case”				                            X


5. Find service*	14
CoR format at least there				                            X
First item found and output formatted correctly		          X
Handles “not found case”				                            X


6a.  Total Insured 	7				                                X
Correct with no claims					                            X
Correct with claims 					                              X
Parallelized* 						                                  X


6a.  Insured For 	9				                                  X
Correct with no claims					                            X
Correct with claims 					                              X
Parallelized* 						                                  X

KNOWN ERRORS:
Within tier 2e, for the test case that tries to load doesnotexist.xml it fails for me because of this:
>>>>>>>Error>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Got.....|could not open file: doesnotexist.xml (no such file or directory)|
Needed..|could not open file: doesnotexist.xml (the system cannot find the file specified)|

The only thing I can think would be causing this is that I am using MacOS and maybe that throws different
errors than Windows??? Everything else seems to work and the code that causes this is:
case e: java.io.FileNotFoundException => println("Could not open file: " + e.getMessage)
so the magic string part is the same, but it's the error message that's different. However, since this
print statement is being triggered by a specific exception I do not know how to fix it as I do not have
a Windows computer I can test on to compare... but no one else I asked ran into this issue :)
Hopefully whatever computer it is tested on does just magically doesn't have the same problem!!
 */
object MainStarter {
    def main(args: Array[String]) = {
        var insuranceManager = new Insurance()

        val menu: String =
            """
              |1) Add Data
              |2) Display Data
              |3) Remove Zip
              |4) Load XML
              |5) Write XML
              |6) Find a Cars of Make in Zip
              |7) Find a Service
              |8) Total Value Insured
              |9) Insurance For
              |0) Quit
              |
              |Choice:> """.stripMargin
        var choice : Any = -1
        var temp = ""

        while (choice != "0") {
            print(menu)

            //something to strip out empty lines
            temp = StdIn.readLine()
            while (temp.isEmpty)
                temp = StdIn.readLine()

            choice = temp

            var result: Unit = choice match {
                case "1" => insuranceManager.addData() // GRADING: ADD
                case "2" => print(insuranceManager.displayData(0)) // GRADING: PRINT
                case "3" => insuranceManager.removeZip()
                case "4" => {
                    print("File name:> ")
                    var fileName: String = StdIn.readLine()
                    try {
                        var topNode = XML.loadFile(fileName)
                        if (topNode.label != "InsuranceData") {
                            println("Invalid XML file. Needs to be an InsuranceData XML file")
                        } else {
                            insuranceManager.readXML(topNode) // GRADING: READ
                        }
                    } catch
                        case e: java.io.FileNotFoundException => println("Could not open file: " + e.getMessage)
                        case e: Exception => println("An error occurred: " + e.getMessage)
                }
                case "5" => {
                    print("File name:> ")
                    var fileName: String = StdIn.readLine()
                    val xmlTree = insuranceManager.writeXML() // GRADING: WRITE

                    val prettyPrinter = new scala.xml.PrettyPrinter(80, 2)
                    val prettyXml = prettyPrinter.format(xmlTree)
                    val write = new FileWriter(fileName)
                    write.write(prettyXml)
                    write.close()
                }
                case "6" => insuranceManager.findVehicles() // GRADING: VEHICLE
                case "7" => insuranceManager.findService() // GRADING: SERVICE
                case "8" => insuranceManager.getValueInsured()
                case "9" => insuranceManager.calculatePayment()
                case "0" => ()
                case _ => print("Invalid input, please try again.")
            }
        }
    }
}


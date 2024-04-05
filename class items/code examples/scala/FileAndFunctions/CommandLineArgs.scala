
package FileAndFunctions



object CommandLineArgs extends App{

  //if using the main function rather than App
  //we would see main(args: Array[String] )

  println("Command Line arguments:")

    //the argument adds a ", " between each String
    println(args.mkString(", "))

    if(args.length > 2){
      println("Command Line at index 2:")
      println(args(2))
    }
  
}
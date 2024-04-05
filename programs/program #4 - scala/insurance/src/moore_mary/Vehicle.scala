package moore_mary

import scala.collection.mutable
import scala.io.StdIn
import scala.xml.Node

class Vehicle() extends RDP {
  var make: String = ""
  var model: String = ""
  var year: Int = 0
  var value: Int = 0

  def addData(): Unit = {
    print("make:> ")
    make = StdIn.readLine()
    print("model:> ")
    model = StdIn.readLine()
    print("year:> ")
    year = StdIn.readInt()
    print("value:> ")
    value = StdIn.readInt()

    println("Added Vehicle")
  }

  def displayData(buffer: Int): String = {
    val bfrStr: String = " " * buffer
    val strWidth: Int = 10

    return bfrStr + "Vehicle: Make: "
      + String.format(s"%-${strWidth}s", make)
      + "Model: " + String.format(s"%-${strWidth}s", model)
      + "Year: " + String.format(s"%-${strWidth}s", year)
      + "Value: $" + String.format(s"%-${strWidth}s", value)
  }

  def readXML(node: Node): Unit = {
    this.make = node.attribute("make").getOrElse("").toString
    this.model = node.attribute("model").getOrElse("").toString
    this.year = node.attribute("year").getOrElse("0").toString.toInt
    this.value = node.attribute("value").getOrElse("0").toString.toInt
  }

  def writeXML(): Node = {
    val attr: mutable.HashMap[String, String] = mutable.HashMap(("value", value.toString),
      ("year", year.toString), ("make", make), ("model", model))
    XMLHelper.makeNode("Vehicle", attr)
  }

  def getValueInsured(): Int = {
    this.value
  }
}

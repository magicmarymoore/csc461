package moore_mary

import scala.collection.mutable
import scala.io.StdIn
import scala.xml.{Node, Text}

class Claim() extends RDP {
  var date: String = ""

  def addData(): Unit = {
    print("date:> ")
    date = StdIn.readLine()

    println("Added Claim")
  }

  def displayData(buffer: Int): String = {
    val bfrStr: String = " " * buffer

    return bfrStr + "Claim: " + date
  }

  def readXML(node: Node): Unit = {
    val children = node.child

    for (child <- children) {
      var tag = child.label
      if (tag =="date") {
        this.date = child.text
      }
    }
  }

  def writeXML(): Node = {
    val txt = Text(date)
    XMLHelper.makeNode("Claim", null, XMLHelper.makeNode("date", null, txt))
  }
}

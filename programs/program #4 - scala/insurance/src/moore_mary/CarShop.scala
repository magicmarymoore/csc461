package moore_mary

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.StdIn
import scala.xml.{Node, Text}

class CarShop() extends RDP, COR {
  var name: String = ""
  var services: ListBuffer[Service] = ListBuffer.empty[Service]

  def addData(): Unit = {
    print("name:> ")
    name = StdIn.readLine()

    var addMore: String = "y"
    while (addMore == "y") {
      print("code:> ")
      var code = StdIn.readInt()
      print("description:> ")
      var description = StdIn.readLine()

      var service = new Service(code, description)
      services += service

      print("Add another element (y/n):> ")
      addMore = StdIn.readLine().toLowerCase()
    }

    println("Added Car Shop")
  }

  def displayData(buffer: Int): String = {
    val divider: String = ".....................................................\n"
    val bfrStr: String = " " * buffer
    var output: String = ""

    output += bfrStr + divider + bfrStr + "Car Shop: " + name + "\n"

    output += services.map(_.displayData(buffer+2)).mkString("\n") + "\n"

    output += bfrStr + divider

    return output
  }

  def readXML(node: Node): Unit = {
    this.name = node.attribute("name").getOrElse("").toString
    val children = node.child

    for (child <- children) {
      var tag = child.label
      if (tag == "CarService") {
        var code = child.attribute("code").getOrElse("0").toString.toInt
        var description = child.text
        var service = new Service(code, description)
        services += service
      }
    }
  }

  def writeXML(): Node = {
    val attr: mutable.HashMap[String, String] = mutable.HashMap(("name", name))
    XMLHelper.makeNode("CarShop", attr, services.map(x => createServiceNode(x)))
  }

  def createServiceNode(service: Service): Node = {
    val attr: mutable.HashMap[String, String] = mutable.HashMap(("code", service.code.toString))
    val txt = Text(service.description)
    XMLHelper.makeNode("CarService", attr, txt)
  }

  def findService(code: Int): Boolean = {
    for (service <- services) {
      if (service.code == code) {
        service.findService(code)
        return true
      }
    }
    
    return false
  }
}

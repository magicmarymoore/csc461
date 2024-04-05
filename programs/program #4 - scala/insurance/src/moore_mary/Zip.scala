package moore_mary
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.StdIn
import scala.xml.Node
import scala.collection.parallel.CollectionConverters._

class Zip(var zipCode: Int) extends RDP, COR{
  var owners: ListBuffer[Owner] = ListBuffer.empty[Owner]
  var shops: ListBuffer[CarShop] = ListBuffer.empty[CarShop]

  def addData(): Unit = {

    var addMore: String = "y"
    while (addMore == "y") {
      print("\nwhat element (owner, car shop ):> ")
      var element = StdIn.readLine().toLowerCase()

      var owner = new Owner()
      var carShop = new CarShop()

      if (element == "owner" || element == "o") {
        owner.addData()
        owners += owner
      } else if (element == "car shop" || element == "c") {
        carShop.addData()
        shops += carShop
      } else {
        println("Invalid option, please try again.")
      }

      print("Add another zip code element (y/n):> ")
      addMore = StdIn.readLine().toLowerCase()
    }
  }

  def displayData(buffer: Int): String = {
    val divider: String = "\n======================================================\n"
    val bfrStr: String = " " * buffer
    var output: String = ""

    output += bfrStr + "Zip Code: " + zipCode
    output += bfrStr + divider

    output += owners.map(_.displayData(buffer+2)).mkString("\n") + "\n"
    output += shops.map(_.displayData(buffer+2)).mkString("\n") + "\n"

    return output
  }

  def readXML(node: Node): Unit = {
    val children = node.child

    for (child <- children) {
      var tag = child.label // type of node
      if (tag == "Owner") {
        var name = child.attribute("name").getOrElse("").toString // name
        var owner = new Owner()
        owner.name = name
        owner.readXML(child)
        owners += owner
      } else if (tag == "CarShop") {
        var name = child.attribute("name").getOrElse("").toString // name
        var shop = new CarShop()
        shop.name = name
        shop.readXML(child)
        shops += shop
      }
    }
  }

  def writeXML(): Node = {
    val attr: mutable.HashMap[String, String] = mutable.HashMap(("code", zipCode.toString))
    XMLHelper.makeNode("ZipCode", attr, owners.map(_.writeXML())++shops.map(_.writeXML()))
  }

  def findVehicles(): Unit = {
    print("Vehicle:> ")
    var make: String = StdIn.readLine()

    for (person <- owners) {
      person.findVehicles(make)
    }
  }

  def findService(code: Int): Boolean = {
    for (shop <- shops) {
        if (shop.findService(code)) {
          print(" found in " + zipCode + "\n")
          return true
        }
    }

    return false
  }

  def getValueInsured(): Int = {
    owners.par.map(_.getValueInsured()).sum //GRADING: PARALLEL
  }

  def calculatePayment(owner: String): Unit = {
    owners.par.find(z => z.name.toLowerCase() == owner.toLowerCase())
      .getOrElse(new Owner()).calculatePayment() // GRADING: INSURANCE
  }
}

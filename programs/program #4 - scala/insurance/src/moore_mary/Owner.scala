package moore_mary

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.io.StdIn
import scala.xml.Node
import scala.collection.parallel.CollectionConverters._

class Owner() extends RDP{
  var name: String = ""
  var vehicles: ListBuffer[Vehicle] = ListBuffer.empty[Vehicle]
  var claims: ListBuffer[Claim] = ListBuffer.empty[Claim]

  def addData(): Unit = {
    print("name:> ")
    name = StdIn.readLine()

    var addMore: String = "y"
    while (addMore == "y") {
      print("\nwhat element (vehicle, claim):> ")
      var element = StdIn.readLine().toLowerCase()

      var vehicle = new Vehicle()
      var claim = new Claim()

      if (element == "vehicle" || element == "v") {
        vehicle.addData()
        vehicles += vehicle
      } else if (element == "claim" || element == "c") {
        claim.addData()
        claims += claim
      } else {
        println("Invalid option, please try again.")
      }

      print("Add another Owner element (y/n):> ")
      addMore = StdIn.readLine().toLowerCase()
    }

    println("Added Owner")
  }

  def displayData(buffer: Int): String = {
    val divider: String = "*****************************************************\n"
    val bfrStr: String = " " * buffer
    var output: String = ""

    output += bfrStr + divider + bfrStr + name + "\n"

    output += bfrStr + "Vehicle(s)\n"
    output += vehicles.map(_.displayData(buffer+2)).mkString("\n") + "\n"

    output += bfrStr + "Claim(s)\n"
    output += claims.map(_.displayData(buffer+2)).mkString("\n") + "\n"

    output += bfrStr + divider

    return output
  }

  def readXML(node: Node): Unit = {
    this.name = node.attribute("name").getOrElse("").toString // name
    val children = node.child

    for (child <- children) {
      var tag = child.label
      if (tag == "Vehicle") {
        var vehicle = new Vehicle()
        vehicle.readXML(child)
        vehicles += vehicle
      } else if (tag == "Claim") {
        var claim = new Claim()
        claim.readXML(child)
        claims += claim
      }
    }
  }

  def writeXML(): Node = {
    val attr: mutable.HashMap[String, String] = mutable.HashMap(("name", name))
    XMLHelper.makeNode("Owner", attr, vehicles.map(_.writeXML()) ++ claims.map(_.writeXML()))
  }

  def findVehicles(make: String): Unit = {

    for (vehicle <- vehicles) {
      if (vehicle.make == make) {
        println(vehicle.displayData(0))
      }
    }
  }

  def getValueInsured(): Int = {
    vehicles.par.map(_.getValueInsured()).sum
  }

  def calculatePayment(): Unit = {
    val vehicleCount = vehicles.length * 25
    val claimCount = claims.length
    val carsTotalValue = vehicles.map(_.value).sum

    val payment = carsTotalValue * 0.001 + vehicleCount + claimCount * carsTotalValue * 0.002

    import java.text.DecimalFormat
    val formatter = new DecimalFormat("#,##0.00")
    println("Monthly Payment: $" + formatter.format(payment))
  }
}

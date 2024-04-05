package moore_mary

import java.io.FileWriter
import scala.collection.mutable.ListBuffer
import scala.io.StdIn
import scala.xml.*
import scala.collection.parallel.CollectionConverters._

class Insurance extends RDP {
  var zipCodes: ListBuffer[Zip] = ListBuffer.empty[Zip]

  def addData(): Unit = {
    print("what zip code:> ")
    var zipCode = StdIn.readInt()

    var zip = new Zip(zipCode)
    if (!zipCodes.exists(_.zipCode == zipCode)) { // if the zip doesn't already exist, add it
      zip.addData()
      zipCodes += zip
    } else {
      println(zipCode + " is already in the database")
    }
  }

  def displayData(buffer: Int): String = {
    return zipCodes.map(_.displayData(0)).mkString("\n")
  }

  def readXML(node: Node): Unit = {
    var children = node.child
    for (child <- children) {
      var tag = child.label // type of node
      if (tag == "ZipCode") {
        var zipCode = child.attribute("code").getOrElse("0").toString.toInt // zip code
        var zip = new Zip(zipCode)
        zip.readXML(child)
        zipCodes += zip
      }
    }
  }

  def writeXML(): Node = {
    XMLHelper.makeNode("InsuranceData", null, zipCodes.map(_.writeXML()))
  }

  def removeZip(): Unit = {
    print("what zip code:> ")
    var zip: Int = StdIn.readInt()
    if (zipCodes.exists(_.zipCode == zip)) { // if the zip code exists, remove it
      zipCodes.filterInPlace(_.zipCode != zip)

      println("Removed " + zip)
    } else {
      println("Zip Code not found")
    }
  }

  def findVehicles(): Unit = {
    print("Zip Code:> ")
    var zip: Int = StdIn.readInt()

    for(code <- zipCodes) {
      if (code.zipCode == zip) {
        code.findVehicles()
      }
    }
  }

  def findService(): Unit = {
    print("Car Service:> ")
    var code: Int = StdIn.readInt()

    for (zip <- zipCodes) {
        if (zip.findService(code)) {
          return
        }
    }

    println(code + " not found")
  }

  def getValueInsured(): Unit = {
    print("What Zip Code:> ")
    var zip: Int = StdIn.readInt()

    var tgtZip = zipCodes.find(z => z.zipCode == zip).getOrElse(new Zip(0))
    val total = tgtZip.getValueInsured()
    
    import java.text.DecimalFormat
    val formatter = new DecimalFormat("#,##0.00")
    println("Value: $" + formatter.format(total))
  }

  def calculatePayment(): Unit = {
    print("What Zip Code:> ")
    var zip: Int = StdIn.readInt()

    print("What Owner:> ")
    var owner: String = StdIn.readLine().toLowerCase

    var tgtZip = zipCodes.par.find(z => z.zipCode == zip).getOrElse(new Zip(0))
    tgtZip.calculatePayment(owner)
  }
}

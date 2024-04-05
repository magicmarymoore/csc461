package moore_mary

import scala.xml.Node

trait RDP {
  def addData(): Unit
  def displayData(buffer: Int): String
  def readXML(node: Node): Unit
  def writeXML(): Node
}

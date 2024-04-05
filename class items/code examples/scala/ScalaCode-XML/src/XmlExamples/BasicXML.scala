package XmlExamples

import scala.collection.mutable
import scala.xml.{Elem, Node, Null, Text, UnprefixedAttribute, XML}

object BasicXML extends App {

  var pets = XML.loadFile("BasicPets.xml")

  
  //changing the xml----------------------------------------------------------------------------------------

  //.child returns a NodeBuffer with each of the direct children
  //this is to CORRECT method to parse a node
  print("\n\nprint all children of pets")
  val children = pets.child
  for (child <- children) {
    print(child)
  }


  //note: .text returns ALL descendant Text nodes contents
  //note: #PCDATA is a place holder for empty nodes and occurs with nice formatting...
  println("\n\n\nPrinting the children's complete information")

  private def printInfo(child: Node): Unit = {
    println("Tag:" + child.label)
    println("Text: " + child.text.strip)
    println("Attributes: " + child.attributes + "\n")
  }
  for (child <- children) {
    printInfo(child)
  }

  /*to make an node in code, use Elem or Text
  located here: https://www.scala-lang.org/api/2.12.12/scala-xml/scala/xml/Elem.html


  Elem(
    prefix: String,
    label: String,
    attributes1: MetaData,
    scope: NamespaceBinding,
    minimizeEmpty: Boolean,
    child: Node*)


    That's annoying, so I made a helper class XMLHelper.scala
  */

  //simplest new node
  private val newPet0 = XMLHelper.makeNode("pet")
  println("\n\n\n\nEmpty node: " + newPet0 )

  //node with attribute
  private val attr1 = mutable.HashMap[String, String](
    ("species", "hamster"),
    ("subtype", "syrian"))
  private val newPet1 = XMLHelper.makeNode("pet", attr1)
  print(newPet1)


  //node with attribute and child text
  private val text = Text("Fluffy")   //Text requires a special node
  private val attr2 = mutable.HashMap[String, String](("species", "hamster"))
  private val newPet2 = XMLHelper.makeNode("pet", attr2, text)
  print("\n"+newPet2)


  //add node with children
  private val attrPerson = mutable.HashMap[String, String](("name", "Bobby"))
  private val newPets = newPet1 ++ newPet2 //needs a sequence of nodes
  private val newPerson = XMLHelper.makeNode("owner", attrPerson, newPets)
  println("\n\n\n\nNew owner: " + newPerson )

  //immutable behind the scenes, so I'm replacing the entire thing!
  pets = XMLHelper.makeNode("pets", null, pets.child ++ newPerson)
  println("\n\n\n\npets with new owner: " + pets)

  //to make the formatting nice, use PrettyPrinter
  private val prettyPrinter = new scala.xml.PrettyPrinter(80, 2)
  private val prettyXml = prettyPrinter.format(pets)
  println("\n\n\n\nNicely formatted: " + prettyXml )
}


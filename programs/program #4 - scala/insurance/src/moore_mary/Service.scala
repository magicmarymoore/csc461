package moore_mary

class Service(val code: Int, val description: String) extends COR {
  def findService(code: Int): Boolean = {
    print(this.code)
    return true
  }

  def displayData(buffer: Int): String = {
    val bfrStr: String = " " * buffer

    return bfrStr + "(" + code + ")" + " " + description
  }
}

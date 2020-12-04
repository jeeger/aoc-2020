import junit.framework.Assert.assertEquals

object Utils {
  def runTestWithInput[T](inputFile: String, testFunction: List[String] => T, expected: T): Unit = {
    val bufferedSource = io.Source.fromInputStream(getClass.getResourceAsStream(inputFile))
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    assertEquals(expected, testFunction(lines))
  }
  
  def runTestFold[T, U](inputFile: String, initial: T, expected: T, foldFunction: (T, String) => T): Unit = {
    val bufferedSource = io.Source.fromInputStream(getClass.getResourceAsStream(inputFile))
    val result = (for (line <- bufferedSource.getLines()) yield line).foldLeft(initial)(foldFunction)
    assertEquals(expected, result)
  }
}

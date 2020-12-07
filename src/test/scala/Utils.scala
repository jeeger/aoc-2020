import junit.framework.Assert.assertEquals

object Utils {
  
  def runWithInput[T](inputFile: String, testFunction: List[String] => T): T = {
    val bufferedSource = io.Source.fromInputStream(getClass.getResourceAsStream(inputFile))
    val lines = (for (line <- bufferedSource.getLines()) yield line).toList
    testFunction(lines)
  }
  
  def testWithInput[T](inputFile: String, testFunction: List[String] => T, expected: T): Unit = {
    assertEquals(expected, runWithInput(inputFile, testFunction))
  }
  
  def runTestFold[T, U](inputFile: String, initial: T, expected: T, foldFunction: (T, String) => T): Unit = {
    val bufferedSource = io.Source.fromInputStream(getClass.getResourceAsStream(inputFile))
    val result = (for (line <- bufferedSource.getLines()) yield line).foldLeft(initial)(foldFunction)
    assertEquals(expected, result)
  }
}

 
import org.junit.Test
import org.junit.Assert._

class AOC1Test {
  @Test
  def testSmall(): Unit = {
    val bufferedSource = io.Source.fromInputStream(getClass.getResourceAsStream("/test-1-small"))
    val lines = (for (line <- bufferedSource.getLines()) yield line.toInt).toSeq
    assertEquals(514579, AOC1.findSum(lines))
  }

  @Test
  def testLarge(): Unit = {
    val bufferedSource = io.Source.fromInputStream(getClass.getResourceAsStream("/test-1-large"))
    val lines = (for (line <- bufferedSource.getLines()) yield line.toInt).toSeq
    assertEquals(290784, AOC1.findSum(lines))
  }

  @Test
  def tripleSmall(): Unit = {
    val bufferedSource = io.Source.fromInputStream(getClass.getResourceAsStream("/test-1-small"))
    val lines = (for (line <- bufferedSource.getLines()) yield line.toInt).toSeq
    assertEquals(241861950, AOC1.findTripleSum(lines))
  }

  @Test
  def tripleLarge(): Unit = {
    val bufferedSource = io.Source.fromInputStream(getClass.getResourceAsStream("/test-1-large"))
    val lines = (for (line <- bufferedSource.getLines()) yield line.toInt).toSeq
    assertEquals(177337980, AOC1.findTripleSum(lines))
  }
}

import org.junit.Test
import org.junit.Assert._

class AOC2Test {
  
  def tobboganCounter(): (Int, String) => Int = {
    (valid, line) => {
    val split = "[- :]+".r.split(line)
    val policy = AOC2.PolicyTobbogan(split(0).toInt, split(1).toInt, split(2)(0))
    if (policy.isValid(split(3))) {
      valid + 1
    } else {
      valid
    }
  }
  }
  
  def sledCounter(): (Int, String) => Int = {
    (valid, line) => {
      val split = "[- :]+".r.split(line)
      val policy = AOC2.PolicySled(split(0).toInt, split(1).toInt, split(2)(0))
      if (policy.isValid(split(3))) {
        valid + 1
      } else {
        valid
      }
    }
  }

  @Test
  def Task1Small(): Unit = {
    Utils.runTestFold("/test-2-small", 0, 2, sledCounter())
  }

  @Test
  def Task1Large(): Unit = {
    Utils.runTestFold("/test-2-Large", 0, 506, sledCounter())
  }

  @Test
  def Task2Small(): Unit = {
    Utils.runTestFold("/test-2-small", 0, 1, tobboganCounter())
  }

  @Test
  def Task2Large(): Unit = {
    Utils.runTestFold("/test-2-Large", 0, 443, tobboganCounter())
  }
}

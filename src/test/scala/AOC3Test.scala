import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

class AOC3Test {
  def parseSlope(lines: List[String]): AOC3.Slope = {
    var x = 0;
    var y = 0;
    var map = scala.collection.mutable.Set[(Int, Int)]()
    var xsize = lines(0).length;
    var ysize = lines.length;
    for (line <- lines) {
      for (char <- line) {
        if (char == '#')
          map.add((x, y))
        x += 1
      }
      x = 0
      y += 1
    }
    new AOC3.Slope(map.toSet, xsize, ysize)
  }

  @Test
  def Task1Small() = Utils.testWithInput("/test-3-small",
    lines => {
      val slope = parseSlope(lines)
      var ride = new AOC3.Ride(slope, (3, 1))
      ride.fullRideTrees()
    }, 7)
  
  @Test
  def Task1Large() = Utils.testWithInput("/test-3-large",
    lines => {
      val slope = parseSlope(lines)
      var ride = new AOC3.Ride(slope, (3, 1))
      ride.fullRideTrees()
    }, 280)

  @Test
  def Task2Small() = Utils.testWithInput("/test-3-small",
    lines => {
        val slope = parseSlope(lines)
        List((1, 1), (3, 1), (5, 1), (7, 1), (1, 2))
          .foldLeft(BigInt(1))((count, sled) => {
            var ride = new AOC3.Ride(slope, sled)
            count * BigInt(ride.fullRideTrees())
          })
    }, BigInt(336))

  @Test
  def Task2Large() = Utils.testWithInput("/test-3-large",
    lines => {
      val slope = parseSlope(lines)
      List((1, 1), (3, 1), (5, 1), (7, 1), (1, 2))
        .foldLeft(BigInt(1))((count, sled) => {
        var ride = new AOC3.Ride(slope, sled)
        count * BigInt(ride.fullRideTrees())
      })
    }, BigInt(60583903))
  
  @Test
  def SledTest() = Utils.runWithInput("/test-3-small", lines => {
    val slope = parseSlope(lines)
    List(((1, 1), 2), ((3, 1), 7), ((5, 1), 3), ((7, 1), 4), ((1, 2), 2))
      .foreach((sled, expected) => {
        var ride = new AOC3.Ride(slope, sled)
        assertEquals(ride.fullRideTrees(), expected)
      })
  })
  
}

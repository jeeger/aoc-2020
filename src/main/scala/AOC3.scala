object AOC3 {

  class Slope(treePos: Set[(Int, Int)], width: Int, height: Int) {
    def treeAt(x: Int, y: Int): Boolean = {
      treePos((x % width, y))
    }

    def finished(x: Int, y: Int): Boolean = y > height;
  }

  class Ride(slope: Slope, sleigh: (Int, Int)) {
    private var x = 0;
    private var y = 0;

    def singleRideTree(): Boolean = {
      x += sleigh._1;
      y += sleigh._2
      slope.treeAt(x, y)
    }

    def fullRideTrees(): Integer = {
      var trees = 0;
      while (!slope.finished(x, y)) {
        if (singleRideTree())
          trees += 1
      }
      trees
    }
  }

}

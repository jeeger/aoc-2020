object AOC1 {
  def findSum(s: Seq[Int]) : Int = {
    for {x <- s; y <- s } {
      if (x + y == 2020) {
        return x * y;
      }
    }
    return 0;
  }

  def findTripleSum(s: Seq[Int]): Int = {
    for {x <- s} {
      if (x < 2020) {
        for {y <- s} {
          if (x + y < 2020) {
            for {z <- s} {
              if (x + y + z == 2020)
                return x * y * z;
            }
          }
        }
      }
    }
    return 0;
  }
}

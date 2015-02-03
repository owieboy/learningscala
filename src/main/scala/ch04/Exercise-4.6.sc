/* Write a function that calculates the difference between a pair of 2d points (x and y)
 and returns the result as a point. Hint: this would be a good use for tuples (“Tuples”). */

def diff(x: Tuple2[Int, Int], y: Tuple2[Int, Int]): Tuple2[Int, Int] = {
  (x._1 - y._1, x._2 - y._2)
}

diff((0,0), (1,1))
/*
Write a function that takes a 2-sized tuple and returns it with the Int value (if included) in the first position.
Hint: this would be a good use for type parameters and the isInstanceOf type operation.
*/

def returnIntFirst[A, B](x: (A, B)) = {
  def isInt(a: Any) = a.isInstanceOf[Int];
  (isInt(x._1), isInt(x._2)) match {
    case (false, true) => (x._2, x._1)
    case _  => x
  }
}

returnIntFirst("a", 1)
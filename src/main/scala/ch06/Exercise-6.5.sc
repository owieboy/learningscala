/*
 Write a function that reverses a list. Can you write this as a recursive function?
 This may be a good place for a match expression.
 */

val inputList = List("1", "333", "22", "4444")
def reverseRec[A](list: List[A]): List[A] = {

  def reverse(listRev: List[A], acc: List[A]) : List[A] = {
    listRev match {
      case Nil => acc
      case head :: tail => reverse(tail, head :: acc)
    }
  }

  reverse(list, List[A]())
}

reverseRec(inputList)
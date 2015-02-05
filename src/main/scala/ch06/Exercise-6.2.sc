/*


Write a function titled "factors" that takes a number and returns a list of its factors,
other than 1 and the number itself. For example, factors(15) should return List(3, 5).

Then write a new function that applies "factors" to a list of numbers.
Try using the list of Long numbers you generated in exercise 1. For example,
executing this function with the List(9, 11, 13, 15) should return List(3, 3, 5),
as the factor of 9 is 3 while the factors of 15 are 3 again and 5. Is this a good place
to use map and flatten? Or, would a for-loop be a better fit?


*/

def factors(number : Int): List[Int] ={
  // iterate only from 2 to number - 1 to exclude 1 and the number itself in checking
  (2 to number -1).toList filter ( number % _ == 0)
}
factors(9)
factors(15)
def applyFlatten[A](list: List[A], fn: (A) => List[A]): List[A] ={
  // list map (fn(_)) --> take every element of list, and apply it function fn
  // fn : (A) => List --> return list of A, therefor list map will result in List(List[A])
  // flatten: Converts a list of lists into a single list of elements.
  list map (fn(_)) flatten
}
applyFlatten[Int](List(9, 11, 13, 15), factors)
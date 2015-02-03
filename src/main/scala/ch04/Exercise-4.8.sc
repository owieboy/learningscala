/*
Write a function that takes a 3-sized tuple and returns a 6-sized tuple,
with each original parameter followed by its String representation.
For example, invoking the function with (true, 22.25, "yes") should return
(true, "true", 22.5, "22.5", "yes", "yes").
Can you ensure that tuples of all possible types are compatible with your function?
When you invoke this function, can you do so with explicit types not only in the function
result but in the value that you use to store the result?
 */

def transform3tuple[A, B, C](given: (A, B, C)) : (A, String, B, String, C, String) = {
  (given._1, given._1 toString, given._2, given._2 toString, given._3, given._3 toString)
}

transform3tuple(("a", 1.0, true))
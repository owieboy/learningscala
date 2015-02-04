/*
Write a function literal that takes two integers and returns the higher number.
Then write a higher-order function that takes a 3-sized tuple of integers plus this
function literal, and uses it to return the maximum value in the tuple.
 */

def maxOfTuple[A](input: (A, A, A), f: (A, A) => A ) = {
  f(input._1, f(input._2, input._3))
}

// Using maxNamedFunction
def maxNamedFunction(x: Int, y:Int) : Int = if(x>y) x else y;
// Using function assigned to a val
val maxAssigned = maxNamedFunction _;
val maxAssigned2: (Int, Int) => Int = maxNamedFunction;
// using inline function literal
val max = (x: Int, y: Int) => if( x > y) x else y;

maxOfTuple((3,5,1), maxNamedFunction);
maxOfTuple((3,5,1), maxAssigned);
maxOfTuple((3,5,1), maxAssigned2);
maxOfTuple((3,5,1), max);



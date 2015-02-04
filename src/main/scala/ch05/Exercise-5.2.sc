/*
The library function util.Random.nextInt returns a random integer.
Use it to invoke the "max" function with two random integers plus a function that returns
the larger of two given integers.

Do the same with a function that returns the smaller of two given integers,
and then a function that returns the second integer every time.
*/


def larger(x: Int, y: Int) = if(x > y) x else y;
def smaller(x: Int, y: Int) = if(x < y) x else y;
def second(x: Int, y: Int) = y;

def chooseBetweenTwoIntegers(first: Int, second: Int, fn: (Int, Int) => Int) = {
  print(first + ", ")
  print(second)
  fn(first, second)
}
chooseBetweenTwoIntegers(util.Random.nextInt(20), util.Random.nextInt(20), larger);
chooseBetweenTwoIntegers(util.Random.nextInt(20), util.Random.nextInt(20), smaller);
chooseBetweenTwoIntegers(util.Random.nextInt(20), util.Random.nextInt(20), second);

def chooseBetweenTwoIntegersCurried(first: Int)(second: Int)(fn: (Int, Int) => Int) = {
  print(first + ", ")
  print(second)
  fn(first, second)
}
// Applying currying
val random2Inputs = chooseBetweenTwoIntegersCurried(util.Random.nextInt(20))(util.Random.nextInt(20)) _;
random2Inputs(larger);
random2Inputs(smaller);
random2Inputs(second);

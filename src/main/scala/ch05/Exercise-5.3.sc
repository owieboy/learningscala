/*
  Write a higher-order function that takes an integer and returns a function.
  The returned function should take a single integer argument (say, "x") and
  return the product of x and the integer passed to the higher-order function.
*/

// long-form
//def fn(input: Int): (Int) => Int = (arg: Int) => arg * input;
// type infered
// def fn(input: Int) = (arg: Int) => arg * input;
// using placeholder
def fn(input: Int): (Int) => Int = _ * input;

val fn3 = fn(3);
fn3(5);
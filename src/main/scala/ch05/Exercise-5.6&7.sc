/* Write a function called "conditional" that takes a value x and two functions, p and f,
and returns a value of the same type as x. The p function is a predicate, taking the value x
and returning a Boolean b. The f function also takes the value x and returns a new value of the same type.
Your "conditional" function should only invoke the function f(x) if p(x) is true, and otherwise return x.

How many type parameters will the "conditional" function require?

*/

def conditional[A](x: A, p: A => Boolean, f: A => A): A = {
  if(p(x)) f(x) else x
}

/*

Do you recall the "typesafe" challenge from the exercises in Chapter 3?
There is a popular coding interview question I’ll call "typesafe",
in which the numbers 1 - 100 must be printed one per line.
The catch is that multiples of 3 must replace the number with the word "type",
while multiples of 5 must replace the number with the word "safe".
Of course, multiples of 15 must print "typesafe".

Use the "conditional" function from exercise 6 to implement this challenge.

Would your solution be shorter if the return type of "conditional" did not
match the type of the parameter x? Experiment with an altered version of the "conditional"
function that works better with this challenge.
*/

for(i <- 1 to 100){
  conditional[Int](i,
      // Predicate to check if divisible by 3 or 5
      t => (t % 3) == 0 || (t % 5) == 0,
      // Return 15 if divisible by both 3 and 5, 3 if only divisible by 3, else 5
      u => if(u % 15 == 0) 15 else if(u %3 == 0) 3 else 5) match {
    case x if x == 15 => print(" typesafe ")
    case x if x == 3 => print(" type ")
    case x if x == 5 => print(" safe ")
    case z => print(" " + z)
  }
}

def alteredConditional[A](x: A, p: A => Boolean, f: A => String) : String = {
  if(p(x)) f(x) else (" " + x.toString)
}

for (i <- 1 to 100) {
  print(alteredConditional[Int](i,
    t => (t % 3) == 0 || (t % 5) == 0,
    u => if(u % 15 == 0) " typesafe " else if(u %3 == 0) " type " else " safe "));
}
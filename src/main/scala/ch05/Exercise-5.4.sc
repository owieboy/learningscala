/*

Let’s say that you happened to run across this function while reviewing another developer’s code:

def fzero[A](x: A)(f: A => Unit): A = { f(x); x }

What does this function accomplish? Can you give an example of how you might invoke it?


 */

// The type parameter A makes this function applicable to varied parameter type, may it be an AnyRef or AnyVal
// The function fzero has two parameter lists, the first parameter list (x: A) accepts values of type A
// The second parameter list should be an expression of function of the type f:A => Unit, possibly some function
// with side-effect

def fzero[A](x: A)(f: A => Unit) = {
  f(x);
  x
}

// example using function with identifier
def printThis[T](s: T) = println(s.toString)
fzero("OwieYeye")(printThis);
// example using function literal
fzero("OwieYeye")(println)
// example using expression block
fzero(1){
  (x: Int) => println(x*2)
}

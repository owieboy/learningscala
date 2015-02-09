/**
 * Created by odelapena on 2/6/15.
The Fibonacci series starts with the numbers "1, 1" and then
computes each successive element as the sum of the previous two elements.
We’ll use this series to get familiarized with the collections in this
chapter.
 *
 */

/*
a) Write a function that returns a list of the first x elements in the
Fibonacci series Can you write this with a Buffer?

Would a Builder be appropriate here?
 */

def fib(inp: Int, counter: Int, acc: collection.mutable.Buffer[Int]): Seq[Int] ={
  inp match {
    case t if t == 1 => acc take 1
    case t if t == 2 => acc take 2
    case t if t == counter => acc
    case t => fib(inp, counter + 1, acc += (acc.takeRight(2).sum))
  }
}

def fibonacci(input: Int): Seq[Int] = {
  fib(input, 2, collection.mutable.Buffer[Int](1, 1))
}

println(fibonacci(1))
println(fibonacci(2))
println(fibonacci(10))

// Would a Builder be appropriate here? -- no, Builder does not have a get method



/*
b) Write a new Fibonacci function that adds new Fibonacci numbers to an
existing list of numbers. It should take a list of numbers (List[Int])
and the count of new elements to add and return a new list (List[Int]).
While the input list and returned lists are immutable, you should be able to use a
mutable list inside your function. Can you also write this function using only immutable
lists? Which version, using mutable vs immutable collections, is more appropriate
and readable?
 */

def fibonacci2(orig: List[Int], number: Int): List[Int] = {
  val builder = List.newBuilder[Int]
  builder ++= orig
  builder ++= fib(number, 2, collection.mutable.Buffer[Int](1, 1))
  builder.result()
}

println(fibonacci2(List(1,2,3), 10))

/*
c) The Stream collection is a great solution for creating a Fibonacci series.
Create a stream that will generate a Fibonacci series.
Use it to print out the first 100 elements in the series, in a formatted report of
10 comma-delimited elements per line.
 */
def fibonacciStream(prev: Long, head: Long): Stream[Long] = Stream.cons(prev, fibonacciStream(head, prev + head))
val fibStr = fibonacciStream(1l, 1l).take(10).toList
println(fibStr)

/*
d) Write a function that takes an element in the Fibonacci series and returns the
following element in the series. For example, fibNext(8) should return 13.

How will you handle invalid input such as fixNext(9) ?
What are your options for conveying the lack of a return value to callers?
 */

def nextFib(input: Int): Option[Long] = {
  val start = fibonacciStream(1, 1)
  val preceeding = start.takeWhile(_ <= input).toList
  if(preceeding.last == input) Some(preceeding.takeRight(2).sum)
  else None
}

println(nextFib(21))
println(nextFib(22))
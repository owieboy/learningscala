/*
There’s a function named "square" that you would like to store in a function value.
Is this the right way to do it? How else can you store a function in a value?


def square(m: Double) = m * m
val sq = square

No! you should use square _, the compiler will complain of missing argument for square

Another method is by specifying the return type
*/

def square(m: Double) = m * m;
val sq = square _
val sq1: Double => Double = square 
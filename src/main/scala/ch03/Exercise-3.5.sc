/*
There is a popular coding interview question I’ll call "typesafe", in which the numbers 1 - 100
must be printed one per line. The catch is that multiples of 3 must replace the number with the
word "type", while multiples of 5 must replace the number with the word "safe". Of course,
multiples of 15 must print "typesafe".
*/

for { i <- 1 to 100} i match {
  case i if (i % 15) == 0 => print(" typesafe ")
  case i if (i % 5) == 0 => print(" safe ")
  case i if (i % 3) == 0  => print(" type")
  case i => print(i + ", ")
}



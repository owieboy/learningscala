/*
Print the numbers 1 to 100, with each line containing a group of 5 numbers. For example:

1, 2, 3, 4, 5,
6, 7, 8, 9, 10
....
*/

for { i <- 1 to 100 } i match
  {
    case i if (i % 5) == 0 => println(i +", ")
    case i => print(i + ", ")
  }
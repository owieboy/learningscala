/*
 Can you rewrite the answer to question 6 to fit on one line? It probably won’t be easier to read, but reducing code to
 its shortest form is an art, and a good exercise to learn the language.
*/
for { i <- 1 to 100} i match { case i if (i % 15) == 0 => print(" typesafe ") case i if (i % 5) == 0 => print(" safe ") case i if (i % 3) == 0  => print(" type") case i => print(i + ", ") }


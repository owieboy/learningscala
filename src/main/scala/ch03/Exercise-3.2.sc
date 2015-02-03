/*
Given a double amount, write an expression to return "greater" if it is more than zero, "same"
if it equals zero, and "less" if it is less than zero. Can you write this with if..else blocks? How about with match expressions?
 */
val doubleAmount : Double = 1.0
if(doubleAmount == 0.0) println("same")
else {
  if(doubleAmount > 0.0) println("greater")
  else println("less")
}

doubleAmount match {
  case doubleAmount if doubleAmount == 0.0 => println("same")
  case doubleAmount if doubleAmount > 0.0 => println("greater")
  case _ => println("less")
}

doubleAmount == 0.0 match {
   case true => println("same")
   case false if doubleAmount > 0.0 => println("greater")
   case _ => println("less")
}
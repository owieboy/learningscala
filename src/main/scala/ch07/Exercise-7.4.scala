/**
 * Created by odelapena on 2/8/15.
 */

/*
 Write a function to return the product of two numbers..
 that are each specified as a String, not a numeric type.

 Will you support both integers and floating-point numbers?
 How will you convey if either or both of the inputs are invalid?
 Can you handle the converted numbers using a match expression?

 How about with a for-loop?
 */

def toDouble (a: String) = util.Try(a.toDouble).toOption

def product(a: String, b: String) = {
  (toDouble(a), toDouble(b)) match {
    case (Some(x), Some(y)) => Some(x * y)
    case _ => None
  }
}

val x = product("yes", "20")
val y = product("99.3", "7")
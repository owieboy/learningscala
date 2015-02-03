/*
*  Provide an alternate form of the function in #1 that takes the radius as a String.
*  What happens if your function is invoked with an empty String ?
* */

def area(radius : String) = {
  3.14 * radius.toDouble * radius.toDouble
}

area("1.0")
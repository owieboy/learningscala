/*
Write a function that calculates the first value raised to the exponent of the second value.
Try writing this first using math.pow, then with your own calculation.
Did you implement it with variables? Is there a solution available that only uses
immutable data? Did you choose a numeric type that is large enough for your uses?
 */

def powerMath(base: Int, exponent : Int): Long = Math.pow(base, exponent) toLong;

powerMath(2, 15)

def power(base: Int, counter: Int, acc: Long = 1): Long = {
  if(counter < 1) acc
  else power(base, counter - 1, acc * base)
}
power(2,15)

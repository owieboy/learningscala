/*
Write a function that takes a milliseconds value and returns a string describing the value in days, hours,
minutes and seconds. What’s the optimal type for the input value?
*/

def convertMils(mils : Long): String = {
  "Seconds : " + mils/1000.0 + "\n" +
  "Minutes : " + (mils/1000.0)/60.0 + "\n" +
  "Hours : " + (mils/1000.0)/60.0/60.0 + "\n" +
  "Days : " + (mils/1000.0)/60.0/60.0/24.0 + "\n"
}
print(convertMils(365000l))
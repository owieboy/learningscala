// Modify the centigrade-to-fahrenheit formula to return an integer instead of a floating-point number.

val nineFifths = 9.0/5.0
val _20degress = 20 * nineFifths
val farenheit: Int = (_20degress + 32).toInt

def cToFInt(tempInC: Double) : Int = ((9.0/5.0)*tempInC + 32) toInt;
cToFInt(20.0)

// Write a new centigrade-to-fahrenheit conversion (using the formula (x * 9/5) + 32),
// saving each step of the conversion into separate values. What do you expect the
// type of each value will be?

val nineFifths = 9.0/5.0
val _20degress = 20 * nineFifths
val farenheit = _20degress + 32

def cToF(temperatureInC : Double): Double = (9.0/5.0)*temperatureInC + 32
cToF(20)
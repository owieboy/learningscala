// Convert the number 128 to a Char, a String, a Double, and then back to an Int.
// Do you expect the original amount to be retained? -- yes
// Do you need any special conversion functions for this? --

val _128 = 128
val char128 : Char =  128
val string128 : String = "" + 128
val double128 : Double = 128

val intChar128 = char128 toInt
val intString128 = string128 toInt
val intDouble128 = double128 toInt
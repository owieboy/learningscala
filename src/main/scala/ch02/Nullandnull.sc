def tryit(thing: Null) : Unit = { println("That worked!")}
/*tryit("hey")

Error:(3, 8) type mismatch;
 found   : String("hey")
 required: Null
tryit("hey");}
      ^
 */

/*val someRef : String = null
tryit(someRef)
Error:(4, 8) type mismatch;
 found   : String
 required: Null
tryit(someRef);}
      ^
*/

tryit(null)


val nullRef: Null = null
tryit(nullRef)
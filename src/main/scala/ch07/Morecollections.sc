val nums = collection.mutable.Buffer(1)

val m = Map("AAPL" -> 5597, "MSFT" -> 40)
val b = m.toBuffer

var x = "String"
var a = Option(x)
x = null
var bn = Option(x)

a.isDefined
bn.isEmpty

val odds = List(1, 3, 5)

val firstOdd = odds.headOption

val evens = odds filter (_ % 2 == 0)
val firstEven = evens.headOption

val words = List("risible", "scavenger", "gist")
val uppercase = words find (w => w == w.toUpperCase)

val lowercase = words find (w => w == w.toLowerCase)

uppercase.getOrElse("else")
lowercase match {
  case Some(x) => x;
  case None => "empty"
}

def loopAndFail(end: Int, failAt: Int): Int = {
  for(i <- 1 to end){
    println(s"$i)")
    if(i == failAt) throw new Exception("Too many iterations")
  }
  end
}

val t1 = util.Try(loopAndFail(2, 3))
val t2 = util.Try(loopAndFail(10, 3))
val nextError = util.Try { 1 / util.Random.nextInt(2)}
val xErr = nextError
val yErr = nextError
//Future Collections
import concurrent.ExecutionContext.Implicits.global
val f = concurrent.Future { println("hi") }
println("waiting")
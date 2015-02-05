// List

val colors = List("red", "green", "blue")
val numbers = List(32, 95, 24, 21, 17)
var total = 0; for(i <- numbers) { total += i}
for(c <- colors) println(c)
// foreach
colors.foreach(println(_))
// map
val sizes = colors.map(_.size)
// reduce
val totalReduce = numbers.reduce(_ + _)
// Set
val unique = Set(10, 20, 30, 20, 20, 10)
val sum = unique.reduce(_ + _)
// Map
val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00, "blue" -> 0xFF)
colorMap.contains("white")
for(pairs <- colorMap) println(pairs);

// recursive traversing of list
val primes = List(2, 3, 5, 7, 11, 13)
def visit(i: List[Int]): Unit ={
  if(i.size >0) {
    print(i.head + ", ")
    visit(i.tail)
  }
}
visit(primes)

var i = primes
while(i != Nil) { print(i.head + ", "); i = i.tail }
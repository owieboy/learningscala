/*
 Create a list of the first 20 odd Long numbers. Can you create this with a for-loop, with the filter operation,
 and with the map operation? What’s the most efficient and expressive way to write this?
 */

var listOdd: List[Long] = List()

val list40 = (1 to 40).toList

for(i <- list40 if i % 2 == 1) yield i

list40 filter(_ % 2 == 1)

// list40.map()
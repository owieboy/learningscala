/*
Write a function, first[A](items: List[A], count: Int): List[A], that returns the first x number of items in a given list.
For example, first(List('a','t','o'), 2) should return List('a','t').
You could make this a one-liner by invoking one of the built-in list operations that already performs this task,
or (preferably) implement your own solution.

Can you do so with a for-loop? With foldLeft?
With a recursive function that only accessed head and tail?

 */

def first[A](items: List[A], count: Int): List[A] = {
  items take count
}

first(List('a', 't', 'o'), 2)

// with for loop
def firstLoop[A](items: List[A], count: Int): List[A] = {
  (for(i<-1 to count; item = items(i-1)) yield item) toList
}

firstLoop(List('a', 't', 'o'), 2)

def firstFoldLeft[A](items: List[A], count: Int): List[A] = {
  items.foldLeft(List[A]())((a,b) => if(a.size >= count) a else (a :+ b))
}

firstFoldLeft(List('a', 't', 'o'), 2)

def firstRec[A](items: List[A], acc: List[A], count: Int): List[A] = {
  if(items.tail == Nil || acc.size >= count ) acc
  else {
    val item = items.head
    firstRec(items.tail, acc :+ item, count)
  }
}

firstRec[Char](List('a', 't', 'o'), List[Char](), 2)

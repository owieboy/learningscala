/*
 Write a function that takes a List[String] and returns a (List[String],List[String]), a tuple of string lists.
 The first list should be items in the original list that are palindromes (written the same forwards and backwards, like "racecar").
 The second list in the tuple should be all of the remaining items from the original list.
 You can implement this easily with partition, but are there other operations you could use instead?
 */

val inputList = List("racecar", "radar", "not", "palindrome", "nasabayabasan");

def partitionPalindrome(list: List[String]): (List[String], List[String]) = {
  list.partition((x) => x == x.reverse)
}

partitionPalindrome(inputList);

def partitionOtherOperation(list: List[String]): (List[String], List[String]) = {
  def partitionPalin(stringList : List[String], accPalindromes: List[String], accNonPalindrome: List[String]): (List[String], List[String]) = {
    stringList match {
      case Nil => (accPalindromes, accNonPalindrome)
      case head :: tail => {
        if(head == head.reverse) partitionPalin(tail, head :: accPalindromes, accNonPalindrome)
        else partitionPalin(tail, accPalindromes, head :: accNonPalindrome)
      }
    }
  }

  partitionPalin(list, List[String](), List[String]())
}

partitionOtherOperation(inputList)
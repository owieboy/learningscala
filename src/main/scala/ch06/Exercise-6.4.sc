/*
Write a function that takes a list of strings and returns the longest string in the list.
Can you avoid using mutable variables here? This is an excellent candidate for the list-folding operations (Table 6-5) we studied.
Can you implement this with both fold and reduce ?
Would your function be more useful if it took a function parameter that compared two strings and returned the preferred one?
How about if this function was applicable to generic lists, ie lists of any type?
 */

val inputList = List("1", "333", "22", "4444")

def longestStringFolding(list : List[String]): String = {
  list.foldLeft("")((a,b) => if(a.length > b.length) a else b)
}

longestStringFolding(inputList)

def longestStringMap(list: List[String]): String = {
  list.reduce((a,b) => if(a.length > b.length) a else b)
}

longestStringMap(inputList)

def longerString = (a: String, b: String) => if(a.length > b.length) a else b;

def longestStringFnParam(list: List[String], fn: (String, String) => String): String = {
  list.reduce(fn)
}

longestStringFnParam(inputList, longerString)

def listFnGeneric[A](list: List[A], fn: (A, A) => A): A = {
  list.reduce(fn)
}

listFnGeneric(inputList, longerString)
/*
* Write a recursive function that prints the values from 5 to 50 by fives, without using for or while loops.
* Can you make it tail-recursive?
* */

def printRec(counter: Int = 5, end: Int = 50): Unit = {
  if(counter > end) print("end")
  else {
    print(counter + ", ")
    printRec(counter + 5, end)
  }
}
printRec(5, 50)
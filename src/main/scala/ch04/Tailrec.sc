def power(base: Int, counter: Int, acc: Int = 1): Int = {
  if(counter < 1) acc
  else power(base, counter -1, base * acc)
}
power(2, 8)
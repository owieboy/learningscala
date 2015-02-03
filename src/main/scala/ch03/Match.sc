val x = 10; val y =20;
x > y match {
  case true => x
  case false=> y
}


val status = 500
val message = status match {
  case 200 => "ok"
  case 400 => { println("ERROR - we called the service incorrectly")
    "error"
  }
  case 500 => {
    println("ERROR - The server encountered an error")
    "error"
  }
}
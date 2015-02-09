import concurrent.ExecutionContext.Implicits.global
import concurrent.Future
val f = concurrent.Future { Thread.sleep(5000); println("Hi") }
println("waiting");

def nextFtr(i: Int = 0) = Future {
  def rand(x: Int) = util.Random.nextInt(x)

  Thread.sleep(rand(5000))
  if(rand(3) > 0) (i+1) else throw new Exception

}

nextFtr(1) fallbackTo nextFtr(2)
nextFtr(1) flatMap nextFtr
nextFtr(1) map (_ * 2)
nextFtr() onSuccess { case x =>s"Got $x" }

def cityTemp(name: String): Double = {
  val url = "http://api.openweathermap.org/data/2.5/weather"
  val cityUrl = s"$url?1=$name"
  val json = io.Source.fromURL(cityUrl).mkString.trim
  val pattern = """.*"temp":([\d.\+).*"""r
  val pattern(temp) = json
  temp.toDouble
}

val cityTemps = Future sequence Seq(Future(cityTemp("Fresno"), Future(cityTemp("Tempe"))))

cityTemps onSuccess {
  case Seq(x,y) if x._1 > y._1 => println(s"Fresno is warmer: $x K")
  case Seq(x,y) if x._1 < y._1 => println(s"Tempe is warmer: $y K")
//  case Seq(x,y) => println("Same temp")

}

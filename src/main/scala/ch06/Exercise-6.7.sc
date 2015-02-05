/*
 The last exercise in this chapter is a multi-part problem.
 We’ll be reading and processing a forecast from the excellent and free OpenWeatherMap API.

To read content from the url we’ll use the Scala library operation io.Source.fromURL(url: String),
which returns an io.Source instance. Then we’ll reduce the source to a collection of individual
lines using the getLines.toList operation. Here is an example of using io.Source to read content from a url,
separate it into lines and return the result as a list of strings.
 */

val url = "http://api.openweathermap.org/data/2.5/forecast?mode=xml&lat=55&lon=0";
val lines: List[String] = io.Source.fromURL(url).getLines.toList

println(lines(0))
/*
a) To make doubly sure we have the right content, print out the top 10 lines of the file.
This should be a one-liner.
 */

for(i <- 1 to 100) println(lines(i))
/*
b) The forecast’s city’s name is there in the first 10 lines. Grab it from the correct line and print
out its xml element. Then extract the city name and country code from their xml elements and print them
out together (e.g., "Paris, FR"). This is a good place to use regular expressions to extract the text from
xml tags (see “Regular Expressions”).
 */
// remove all whitelines and spaces
var linesTrimmed = lines map (_.trim)
def getChild(tag: String) = linesTrimmed filter (_ contains s"<$tag>") mkString "" replaceAll(".*>(\\w+)</.*", "$1")
val cityName = getChild("name")
val country = getChild("country")
/*
c) How many forecast segments are there?
What is the shortest expression you can write to count the segments?
 */
val countForecast = lines.filter(_ contains "</time>").size
/*
d) The "symbol" xml element in each forecast segment includes a description of the weather forecast.
Extract this element in the same way you extracted the city name and country code.
Try iterating through the forecasts, printing out the description.
 */
def attribute(tag: String, attr: String) = {
 linesTrimmed.filter(_ contains s"<$tag").filter(_ contains s"$attr=").map{ s => s.replaceAll(s""".*$attr="([^"]+)".*""", "$1")}
}
val names = attribute("symbol", "name")
val forecast = attribute("time", "from") zip attribute("symbol", "name") take 4;
{
  println("12 hour forecast")
  forecast foreach {
    case (time, desc) =>
      val when = time.replaceAll("""T(\d+).*""",""" at $100""")
      println(s"$when | $desc")
  }
}
/*
e) Let’s find out what descriptions are used in this forecast.
Print a sorted listing of all of these descriptions in the forecast, with duplicate entries removed.
 */
val termsSorted = attribute("symbol", "name").distinct.sorted;

/*

f) These descriptions may be useful later. Included in the "symbol" xml element is an attribute
containing the symbol number. Create a Map from the symbol number to the description.
Verify this is accurate by manually accessing symbol values from the forecast and checking that the
description matches the xml document.
 */

val symbolNumbers = attribute("symbol", "number")
val symbolDesc = attribute("symbol", "name")
val mapSymbolDescription = symbolNumbers zip symbolDesc;
/*
g) What are the high and low temperatures over the next 24 hours?
 */
val minTemp = attribute("temperature", "min");
val lowestTemp = minTemp.min;
val maxTemp = attribute("temperature", "max");
val highestTemp = maxTemp.max;

/*
h) What is the average temperature in this weather forecast?
You can use the "value" attribute in the temperature element to calculate this value.
 */
val valueTemps = attribute("temperature", "value").map(_.toDouble);
val averageTemp = valueTemps.sum / valueTemps.size
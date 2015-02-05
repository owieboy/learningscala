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

// Will continue working on this using XML parser library :)
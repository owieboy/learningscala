/**
 * Created by odelapena on 2/8/15.
 * This solution is copied from the author's posted solution in
 * https://github.com/swartzrock/LearningScalaMaterials/blob/master/Exercises/ch7-MoreCollections.asciidoc
 */

/*
 Write a function that reports recent Github commits for a project.
 Github provides an RSS feed of recent commits for a given user,
 repository and branch, containing xml that you can parse out with
 regular expressions. Your function should take the user,
 repository and branch, read and parse the RSS feed,
 and then print out the commit information.
 This should include the date, title and author of each commit.

You can use the following RSS url to retrieve recent commits for
a given repository and branch:

https://github.com/<user name>/<repo name>/commits/<branch name>.atom
 */

/*
 a) Move the user, repo and branch parameters into a tuple parameter.
 */

def getFeeds(uname: String, repo: String, branch: String) = {
  val url = s"https://github.com/$uname/$repo/commits/$branch.atom"
  val xml = io.Source.fromURL(url)
  val text = xml.getLines.map(_.trim).mkString("")
  text
}

def child(xml: String, name: String): Option[String] = {
  val p = s".*<$name>(.*)</$name>.*".r
  xml match {
    case p(result) => Option(result)
    case _ => None
  }
}

def xmlToEntryList(xml: String) = xml.split("</?entry>").filterNot(_.isEmpty).tail

/*
http://alvinalexander.com/scala/how-to-use-multiple-options-for-loop-comprehension

if one of title, date or author is None, return None
*/
def report(entryXml: String): Option[String] = {
  for {
    title <- child(entryXml, "title")
    date <- child(entryXml, "updated").map(_.replaceAll("T.*", ""))
    author <- child(entryXml, "name")
  } yield s"title: $title\ndate: $date\nauthor: $author"
}

def getGithubReport(user: String, repo: String, branch: String): String = {
  val xml = getFeeds(user, repo, branch)
  val entries = xmlToEntryList(xml).toList
  // Flatmap calls map operation then flatten
  val formattedEntries = entries flatMap report
  val title = s"Github commit activity for $repo:$branch"
  title :: formattedEntries mkString ("\n" + "=" * 80 + "\n")
}

println(getGithubReport("owieboy", "learningscala", "master"))

/*
a) Move the user, repo and branch parameters into a tuple parameter.
*/
def getGithubReportTuple(urb: (String, String, String)): String = {
  val xml = getFeeds(urb._1, urb._2, urb._3)
  val entries = xmlToEntryList(xml).toList
  // Flatmap calls map operation then flatten
  val formattedEntries = entries flatMap report
  val title = s"Github commit activity for ${urb._2}:${urb._3}"
  title :: formattedEntries mkString ("\n" + "=" * 80 + "\n")
}
println("Use tuple parameter")
println(getGithubReportTuple(("owieboy", "learningscala", "master")))

val slickMasterUrb = ("slick", "slick", "master")
val owieboyMasterUrb = ("owieboy", "learningscala", "master")

/*
b) Following exercise "a", have the function take a list of Github projects and print a report of each one’s commits,
in order of specified project.
*/
def getGithubReportTuples(urbs: List[(String, String, String)]) = urbs map getGithubReportTuple
println("*" * 80 + "Use tuple parameter list")
println(getGithubReportTuples(List(owieboyMasterUrb, slickMasterUrb)))

/*c) Following exercise "b", retrieve all of the projects commit data concurrently using futures,
await the result (no more than 5 seconds), and then print a commit report for each project,
in order of project specified.*/
def getGithubReportTupleWithBranchInfo(urb: (String, String, String)): List[String] = {
  val xml = getFeeds(urb._1, urb._2, urb._3)
  val entries = xmlToEntryList(xml).toList
  // Flatmap calls map operation then flatten
  val branchInfo = s"branch: ${urb._2}:${urb._3}\n"
  entries flatMap report map (branchInfo + _)
}


def getGithubReportsFuture(urbs: List[(String, String, String)]): String = {
  val commits = List.newBuilder[String]

  import concurrent.ExecutionContext.Implicits.global
  val futures = urbs map { urb =>
    concurrent.Future { commits ++= getGithubReportTupleWithBranchInfo(urb) }
  }
  val future = concurrent.Future.sequence(futures)
  import concurrent.duration._
  concurrent.Await.result(future, Duration(5, SECONDS))

  val separator = "\n" + "="*60 + "\n"
  val title = s"Github activity for ${urbs map (_._1) mkString (", ")} repos"
  (title :: commits.result) mkString separator
}
println(getGithubReportsFuture(List(owieboyMasterUrb, slickMasterUrb)))
/*
d) Following exercise "c", mix the commits together and sort by commit date, then print your report with an
additional "repo" column.
 */

def getGithubReportsSortedByDate(urbs: List[(String, String, String)]): String = {
  val commits = List.newBuilder[String]
  import concurrent.ExecutionContext.Implicits.global

  val futures = urbs map {
    urb => concurrent.Future { commits ++= getGithubReportTupleWithBranchInfo(urb)}
  }
  val future = concurrent.Future.sequence(futures)
  import concurrent.duration._
  concurrent.Await.result(future, Duration(5, SECONDS))

  val separator = "\n" + "="*60 + "\n"
  val title = s"Github activity for ${urbs map (_._1) mkString (", ")} repos"

  val sortedCommits = commits.result.sortBy{
    c => c.replaceAll("s(?s).*date:", "").replaceAll("(?s)\\s.*", "")
  }.reverse
  (title :: sortedCommits) mkString separator
}
println(getGithubReportsSortedByDate(List(owieboyMasterUrb, slickMasterUrb)))
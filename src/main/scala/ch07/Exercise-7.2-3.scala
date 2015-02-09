/**
 * Created by odelapena on 2/8/15.
 */

/*
 In the example for Array collections (“Arrays”) we used the java.io.File(<path>).listFiles
 operation to return an array of files in the current directory.
 Write a function that does the same thing for a directory,
 and converts each entry into its String representation using the toString method.
 Filter out any dot-files (files which begin with the character .)
 and print the rest of the files separated by a semi-colon (;).


 Test this out in a directory on your computer that has a significant number of files.
 */

def fileNames = {
  val files = new java.io.File("/home/odelapena").listFiles()
  files map (_.getName) filterNot (_.startsWith("."))
}

println(fileNames mkString "\n")
val mappingList = fileNames.groupBy(_.toLowerCase.charAt(0)).toList
for{ (character, list) <- mappingList } { println(s"'$character' has ${list.size} files")}
/**
 * Created by odelapena on 2/8/15.
 */

/*
Write a function to safely wrap calls to the JVM library method
System.getProperty(<String>), avoiding raised exceptions or null results.
System.getProperty(<String>) returns a JVM environment property
value given the property’s name.

For example, System.getProperty("java.home") will return the path
to the currently running Java instance while
System.getProperty("user.timezone") returns the time zone property
from the operating system.

This method can be dangerous to use, however, since it may
throw exceptions or return null for invalid inputs.
Try invoking System.getProperty("") or System.getProperty("blah")
from the Scala REPL to see how it responds.
 */
def getProperty(s: String): Option[String] = {
  util.Try( System.getProperty(s)) match {
    case util.Success(x) => Option(x)
    case util.Failure(ex) => None
  }
}

println(getProperty(null))
println(getProperty("os.arch"))
println(getProperty("blargh"))
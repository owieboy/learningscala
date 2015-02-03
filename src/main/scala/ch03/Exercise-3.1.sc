val name = ""
name match {
  case name if name.length > 0 => s"$name"
  case _ => "n/a"
}
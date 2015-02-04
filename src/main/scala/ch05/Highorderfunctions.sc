def safeStringOps(s: String, f: String => String) = {
  if( s != null) f(s) else s
}

val reverser = (s: String) => s.reverse;

safeStringOps(null, reverser);
safeStringOps("OwieYeye", reverser);
safeStringOps(null, (s: String) => s.reverse);
safeStringOps("YeyeOwie", (s: String) => s.reverse);
// using function literal + type inference
safeStringOps("OwYe", s => s.reverse)


// Using inline function literals

val greeter = (name: String) => s"Hello Yeye and $name"
val hi = greeter("Owie")

def max(a: Int, b: Int) = if(a > b) a else b;
// assigned a function value
val maximize: (Int, Int) => Int = max;
// as redefined with a function literal
val maximize2 = (a: Int, b: Int) => if(a > b) a else b;

// Using placeholder syntax
def combination(x: Int, y: Int, f: (Int, Int) => Int) = f(x,y);
def multiplier(a: Int, b: Int) = a * b;
val multiplier2 = multiplier _
val multiplier3: (Int, Int) => Int = multiplier
combination(2, 3, (x: Int, y: Int) => x*y);
combination(2,3, (x, y) => x*y);
combination(2,3, multiplier);
combination(2,3, multiplier2);
combination(2,3, multiplier3);
combination(2,3, _ * _);

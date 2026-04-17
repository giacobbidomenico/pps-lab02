package task2

object Function:

  //a

  val positive: Int => String =
    case n if n >= 0 => "positive"
    case _ => "negative"

  def positiveDef(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _  => "negative"

  val empty: String => Boolean = _ == ""

  val neg = (p: String => Boolean) => (x: String) => !p(x)
  val notEmpty = neg(empty)

  def negDef(p: String => Boolean): String => Boolean =
    (x: String) => !p(x)
  val notEmptyDef = negDef(empty)

  @main def runFunction(): Unit =
    println(positive(-5))
    println(positive(6))

    println(positiveDef(-5))
    println(positiveDef(6))

    println(notEmpty("foo"))
    println(notEmpty(""))
    println(notEmpty("foo") && !notEmpty(""))


    println(notEmptyDef("foo"))
    println(notEmptyDef(""))
    println(notEmptyDef("foo") && !notEmptyDef(""))
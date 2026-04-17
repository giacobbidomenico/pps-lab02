package task2

object Function:

  //a

  val positive: Int => String =
    case n if n >= 0 => "positive"
    case _ => "negative"

  def positiveDef(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _  => "negative"

  @main def runFunction(): Unit =
    println(positive(-5))
    println(positive(6))

    println(positiveDef(-5))
    println(positiveDef(6))

  
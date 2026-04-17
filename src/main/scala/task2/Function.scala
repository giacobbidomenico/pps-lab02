package task2

object Function:

  //a
  val positive: Int => String =
    case n if n >= 0 => "positive"
    case _ => "negative"

  def positiveDef(x: Int): String = x match
    case n if n >= 0 => "positive"
    case _  => "negative"

  //b
  val empty: String => Boolean = _ == ""

  val neg: (String => Boolean) => String => Boolean = (p: String => Boolean) => (x: String) => !p(x)
  def negDef(p: String => Boolean): String => Boolean = (x: String) => !p(x)

  //c
  def negG[A](p: A => Boolean): A => Boolean = (x: A) => !p(x)

  @main def testPositive(): Unit =
    println(positive(-5))
    println(positive(6))

    println(positiveDef(-5))
    println(positiveDef(6))

  private def printNet(notEmpty: String => Boolean): Unit =
    println(notEmpty("foo"))
    println(notEmpty(""))
    println(notEmpty("foo") && !notEmpty(""))
  
  @main def testNeg(): Unit =
    val notEmpty: String => Boolean = neg(empty)
    printNet(notEmpty)
  
  @main def testNegMethod(): Unit =
    val notEmpty: String => Boolean = negDef(empty)
    printNet(notEmpty)

  @main def testGenericNeg(): Unit =
    val notEmpty: String => Boolean = negG[String](empty)
    printNet(notEmpty)
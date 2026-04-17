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

  //4
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  val p2: (Int, Int, Int) => Boolean = (x: Int, y:Int, z: Int) => x <= y && y == z
  def p3(x: Int)(y: Int)(z: Int): Boolean = x <= y && y == z
  def p4(x: Int, y: Int, z: Int): Boolean = x <= y && y == z

  //5
  def compose[A, B, C](f: B => C, g: A => B): A => C = (x: A) => f(g(x))

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

  @main def testP1(): Unit =
    println(p1(3)(4)(4))
    println(p1(3)(5)(4))
    println(p1(7)(5)(4))

  @main def testP2(): Unit =
    println(p2(3, 4, 4))
    println(p2(3, 5, 4))
    println(p2(7, 5, 4))

  @main def testP3(): Unit =
    println(p3(3)(4)(4))
    println(p3(3)(5)(4))
    println(p3(7)(5)(4))

  @main def testP4(): Unit =
    println(p4(3, 4, 4))
    println(p4(3, 5, 4))
    println(p4(7, 5, 4))

  @main def testCompose(): Unit =
    println(compose[Int, Int, Int](_- 1, _ * 2)(5))
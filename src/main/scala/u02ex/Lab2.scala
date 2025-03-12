package u02ex

object Lab2 extends App:

  //Task 1

  def divide(x: Double, y: Double): Double = x / y

  def divideCurried(x: Double)(y: Double): Double = x / y

  //different inputs
  println(s"divide(3,4): ${divide(3, 4)}, divideCurried(3)(4): ${divideCurried(3)(4)}")
  println(s"divide(3.5,-4.79): ${divide(3.5, -4.79)}, divideCurried(3.5)(-4.79): ${divideCurried(3.5)(-4.79)}")

  //edge cases
  println(s"divide(0, 3.5): ${divide(0, 3.5)}, divideCurried(0)(3.5): ${divideCurried(0)(3.5)}")
  println(s"divide(3.5, 0): ${divide(3.5, 0)}, divideCurried(3.5)(0): ${divideCurried(3.5)(0)}")

  //divide curried by 3
  val divideCurriedBy3 = divideCurried(3)
  println(s"divideCurriedBy3: $divideCurriedBy3")


  //Task 2

  //3
  //a
  val positiveLambda: Int => String = _ match
    case x if x < 0 => "negative"
    case _ => "positive"

  def positiveMethod(x : Int): String = x match
    case x if x < 0 => "negative"
    case _ => "positive"

  println(s"positive lambda of 3: ${positiveLambda(3)} and -3: ${positiveLambda(-3)}")
  println(s"positive method of 3: ${positiveMethod(3)} and -3: ${positiveMethod(-3)}")

  //b
  def neg(predicate: String => Boolean): String => Boolean = s => !predicate(s)

  val negLambda: (String => Boolean) => (String => Boolean) = predicate => s => !predicate(s)

  def negMethod(predicate: String => Boolean): String => Boolean = s => !predicate(s)

  val empty: String => Boolean = _ == ""
  val notEmpty = neg(empty)
  println(s"notEmpty(\"foo\"): ${notEmpty("foo")}") // true
  println(s"notEmpty(\"\"): ${notEmpty("")}") // false
  println(s"notEmpty(\"foo\") && !notEmpty(\"\"): ${notEmpty("foo") && !notEmpty("")}")

  //c
  def negGeneric[A](predicate: A => Boolean): A => Boolean = (a: A) => !predicate(a)
  val isEven: Int => Boolean = _ % 2 == 0
  val isOdd = negGeneric(isEven)

  println(s"isOdd(3): ${isOdd(3)}")
  println(s"isOdd(4): ${isOdd(4)}")
  println(s"isEven(3): ${isEven(3)}")
  println(s"isEven(4): ${isEven(4)}")

  //4
  val p1: Int => Int => Int => Boolean = x => y => z => x <= y && y == z
  println(s"p1(3)(4)(4):${p1(3)(4)(4)}")
  println(s"p1(5)(4)(4):${p1(5)(4)(4)}")

  val p2: (Int, Int, Int) => Boolean = (x,y,z) => x <= y && y == z
  println(s"p2(3,4,4):${p2(3,4,4)}")
  println(s"p2(5,4,4):${p2(5,4,4)}")

  def p3(x:Int)(y:Int)(z:Int):Boolean = x <= y && y == z
  println(s"p3(3)(4)(4):${p3(3)(4)(4)}")
  println(s"p3(5)(4)(4):${p3(5)(4)(4)}")

  def p4(x: Int,y: Int,z: Int): Boolean = x <= y && y == z
  println(s"p4(3,4,4):${p4(3, 4, 4)}")
  println(s"p4(5,4,4):${p4(5, 4, 4)}")

  //5
  def compose(f: Int => Int, g: Int => Int): Int => Int = x => f(g(x))
  println(s"compose(_- 1, _ * 2)(5):${compose(_- 1, _ * 2)(5)}")

  /**
   * Non si può usare direttamente composeGeneric(_- 1, _ * 2)(5)
   * Gli underscore _ rappresentano funzioni anonime, ma senza un contesto
   * tipizzato, il compilatore non può determinare automaticamente i tipi A, B, C.
   */
  def composeGeneric[A, B, C](f: B => C, g: A => B): A => C = x => f(g(x))
  println(s"composeGeneric[Int, Int, Int](_- 1, _ * 2)(5):${composeGeneric[Int,Int,Int](_- 1, _ * 2)(5)}")

  //6
  def composeThree[A,B,C,D](f: C => D, g: B => C, h: A => B): A => D = composeGeneric(f,composeGeneric(g, h))
  println(s"${composeThree[Int, Int, String, String](_ + "!", _.toString, _ * 2)(3)}")
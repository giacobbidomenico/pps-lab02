package task3

object Recursion:

  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)


  @main def testPower(): Unit =
    println(power(2, 3))
    println(power(5, 2))

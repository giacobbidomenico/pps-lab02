package task3

object Recursion:

  // 7

  def power(base: Double, exponent: Int): Double = exponent match
    case 0 => 1
    case _ => base * power(base, exponent - 1)


  @main def testPower(): Unit =
    println(power(2, 3))
    println(power(5, 2))

  // 8

  def reverseNumber(n: Int): Int =
    @annotation.tailrec
    def _reverse(n: Int, acc: Int): Int = n match
      case 0 => acc
      case n => _reverse(n / 10, acc * 10 + n % 10)
    _reverse(n, 0)

  @main def testReverse(): Unit =
    println(reverseNumber(5341))

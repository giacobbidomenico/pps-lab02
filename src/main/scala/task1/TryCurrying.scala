package task1

def mul(x: Double, y: Double): Double = x * y

def mulCurried(x: Double)(y: Double): Double = x * y

def divide(den: Double, num: Double) : Double = den / num

def divideCurried(den: Double)(num: Double): Double = den / num

@main def runTryCurrying(): Unit =
  println(mul(3,4))
  println(mulCurried(3)(4))

  val multiplyBy3 = mulCurried(3)
  println(multiplyBy3(4))

  println(divide(3, 4))
  println(divideCurried(3)(4))

  val dividedBy3 = divideCurried(3)
  println(dividedBy3(4))
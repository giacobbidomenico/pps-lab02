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
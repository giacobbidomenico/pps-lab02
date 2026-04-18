package task5

object Optionals:

  enum Optional[+A]:
    case Just(value: A)
    case Empty()

  def isEmpty[A](opt: Optional[A]): Boolean = opt match
    case Optional.Empty() => true
    case _                => false

  def orElse[A](opt: Optional[A], orElse: A): A = opt match
    case Optional.Just(a) => a
    case _                => orElse

  def map[A, B](opt: Optional[A])(f: A => B): Optional[B] = opt match
    case Optional.Just(a) => Optional.Just(f(a))
    case _                => Optional.Empty()

  def filter[A](opt: Optional[A])(p: A => Boolean): Optional[A] = opt match
    case Optional.Just(a) if p(a) => Optional.Just(a)
    case _                        => Optional.Empty()

@main def tryOptionals(): Unit =
  import Optionals.*
  import Optional.*

  val s1: Optional[Int] = Just(1)
  val s2: Optional[Int] = Empty()

  println(s1)
  println(isEmpty(s1))
  println(orElse(s1, 0))
  println(orElse(s2, 0))

  println(map(Just(5))(_ > 2)) // Just(true)
  println(map(Empty[Int]())(_ > 2)) // Empty()

  println(filter(Just(5))(_ > 2)) // Just(5)
  println(filter(Just(5))(_ > 8)) // Empty()
  println(filter(Empty[Int]())(_ > 2)) // Empty()
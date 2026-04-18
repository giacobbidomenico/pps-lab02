package task5

import org.junit.*
import org.junit.Assert.*
import Optionals.*
import Optional.*

class OptionalIntTest:

  @Test def emptyOptionalShouldBeEmpty(): Unit =
    val empty: Optional[Int] = Empty()
    assertTrue(isEmpty(empty))

  @Test def nonEmptyOptionalShouldNotBeEmpty(): Unit =
    val nonEmpty = Just(0)
    assertFalse(isEmpty(nonEmpty))

  @Test def orElseShouldReturnDefaultWhenEmpty(): Unit =
    val empty: Optional[Int] = Empty()
    assertEquals(1, orElse(empty, 1))

  @Test def orElseShouldReturnValueWhenNonEmpty(): Unit =
    val nonEmpty = Just(0)
    assertEquals(0, orElse(nonEmpty, 1))

  @Test def testMap(): Unit =
    assertEquals(Just(true), map(Just(5))(_ > 2))
    assertEquals(Empty(), map(Empty[Int]())(_ > 2))

  @Test def testFilter(): Unit =
    assertEquals(Just(5), filter(Just(5))(_ > 2))
    assertEquals(Empty(), filter(Just(5))(_ > 8))
    assertEquals(Empty(), filter(Empty[Int]())(_ > 2))
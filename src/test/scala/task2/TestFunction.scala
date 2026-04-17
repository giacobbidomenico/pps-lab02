package task2

import org.junit.*
import org.junit.Assert.*
import Function.*

class TestFunction:

  @Test def testPositive(): Unit =
    assertEquals("positive", positive(2))
    assertEquals("negative", positive(-2))

  @Test def testPositiveDef(): Unit =
    assertEquals("positive", positiveDef(2))
    assertEquals("negative", positiveDef(-2))

  def testNotEmpty(notEmpty: String => Boolean): Unit =
    assertEquals(true, notEmpty("foo"))
    assertEquals(false, notEmpty(""))
    assertEquals(true, notEmpty("foo") && !notEmpty(""))

  @Test def testNeg(): Unit =
    val notEmpty: String => Boolean = neg(empty)
    testNotEmpty(notEmpty)

  @Test def testNegMethod(): Unit =
    val notEmpty: String => Boolean = negDef(empty)
    testNotEmpty(notEmpty)

  @Test def testGenericNeg(): Unit =
    val notEmpty: String => Boolean = negG[String](empty)
    testNotEmpty(notEmpty)
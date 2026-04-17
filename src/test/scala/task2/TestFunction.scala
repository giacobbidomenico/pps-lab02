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

  @Test def testNotEmpty(): Unit =
    assertEquals(true,  notEmpty("foo"))
    assertEquals(false, notEmpty(""))
    assertEquals(true,  notEmpty("foo") && !notEmpty(""))

  @Test def testNotEmptyDef(): Unit =
    assertEquals(true,  notEmptyDef("foo"))
    assertEquals(false, notEmptyDef(""))
    assertEquals(true,  notEmptyDef("foo") && !notEmptyDef(""))
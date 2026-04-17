package task3

import org.junit.*
import org.junit.Assert.*
import Recursion.*

class TestRecursion:

  @Test def testPower(): Unit =
    assertEquals(8.0, power(2, 3), 0.0)
    assertEquals(9.0, power(3, 2), 0.0)
    assertEquals(1.0, power(5, 0), 0.0)

  @Test def testReverse(): Unit =
    assertEquals(1435, reverseNumber(5341))
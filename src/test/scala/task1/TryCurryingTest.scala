package task1

import org.junit.*
import org.junit.Assert.*

class TryCurryingTest:

  @Test def testMul(): Unit =
    assertEquals(12.0, mul(3, 4), 0.0)

  @Test def testMulCurried(): Unit =
    val multiplyBy5 = mulCurried(5.0)
    assertEquals(10.0, multiplyBy5(2.0), 0.0)
    assertEquals(50.0, multiplyBy5(10.0), 0.0)

  @Test def testDivide(): Unit =
    assertEquals(5.0, divide(10.0, 2.0), 0.0)

  @Test def testDivideCurried(): Unit =
    val divideTenBy = divideCurried(10.0)
    assertEquals(5.0, divideTenBy(2.0), 0.0)
    assertEquals(0.333, divideCurried(1.0)(3.0), 0.001)
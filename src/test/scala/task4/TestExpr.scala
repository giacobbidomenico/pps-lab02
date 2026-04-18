package task4

import org.junit.*
import org.junit.Assert.*
import task4.Expr.*


class TestExpr:

  @Test def testEvaluateLiteral(): Unit =
    val expr = Expr.Literal(5)
    assertEquals(5, Expr.evaluate(expr))

  @Test def testEvaluateAdd(): Unit =
    val expr = Expr.Add(Expr.Literal(2), Expr.Literal(3))
    assertEquals(5, Expr.evaluate(expr))

  @Test def testEvaluateMultiply(): Unit =
    val expr = Expr.Multiply(Expr.Literal(3), Expr.Literal(2))
    assertEquals(6, Expr.evaluate(expr))

  @Test def testEvaluateNestedExpression(): Unit =
    val expression =
      Expr.Add(
        Expr.Literal(2),
        Expr.Multiply(Expr.Literal(3), Expr.Literal(4))
      )
    assertEquals(14, Expr.evaluate(expression))

    val expression1 =
      Expr.Multiply(
        Expr.Add(Expr.Literal(1), Expr.Literal(2)),
        Expr.Add(Expr.Literal(3), Expr.Literal(4))
      )
    assertEquals(21, Expr.evaluate(expression1))

  @Test def testShowLiteral(): Unit =
    val expr = Expr.Literal(5)
    assertEquals("5", Expr.show(expr))

  @Test def testShowAddition(): Unit =
    val addition = Expr.Add(Expr.Literal(1), Expr.Literal(2))
    assertEquals("(1 + 2)", Expr.show(addition))

  @Test def testShowMultiplication(): Unit =
    val multiplication = Expr.Multiply(Expr.Literal(3), Expr.Literal(4))
    assertEquals("(3 * 4)", Expr.show(multiplication))

  @Test def testNestedShow(): Unit =
    val expression =
      Expr.Add(
        Expr.Literal(2),
        Expr.Multiply(Expr.Literal(3), Expr.Literal(4))
      )
    assertEquals("(2 + (3 * 4))", Expr.show(expression))

    val expression1 =
      Expr.Multiply(
        Expr.Add(Expr.Literal(1), Expr.Literal(2)),
        Expr.Add(Expr.Literal(3), Expr.Literal(4))
      )
    assertEquals("((1 + 2) * (3 + 4))", Expr.show(expression1))
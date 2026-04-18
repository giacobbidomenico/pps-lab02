package task4

enum Expr:
  case Literal(value: Int)
  case Add(left: Expr, right: Expr)
  case Multiply(left: Expr, right: Expr)

object Expr:
  def evaluate(expr: Expr): Int = expr match
    case Literal(value: Int) => value
    case Add(left: Expr, right: Expr) => evaluate(left) + evaluate(right)
    case Multiply(left: Expr, right: Expr) => evaluate(left) * evaluate(right)

  def show(expr: Expr): String = expr match
    case Literal(value: Int) => value.toString
    case Add(left: Expr, right: Expr) => "(" + show(left) + " + " + show(right) + ")"
    case Multiply(left: Expr, right: Expr) => "(" + show(left) + " * " + show(right) + ")"




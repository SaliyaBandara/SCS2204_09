class Rational(n: Int, d: Int) {
  require(d != 0)
  val numerator: Int = n
  val denominator: Int = d
  def neg: Rational = new Rational(-numerator, denominator)
  def sub(that: Rational): Rational =
    new Rational(
      numerator * that.denominator - that.numerator * denominator,
      denominator * that.denominator
    )

  override def toString: String = s"$numerator/$denominator"
}

@main def init() ={
  val x = new Rational(1, 2)
  val result = x.neg

  println(result)
}
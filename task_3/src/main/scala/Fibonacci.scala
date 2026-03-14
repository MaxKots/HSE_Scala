object Fibonacci extends App {

  // Как вариант фибоначчи через зип на себя
  lazy val fib: LazyList[BigInt] = BigInt(0) #:: BigInt(1) #:: fib.zip(fib.tail).map { case (a, b) => a + b }

  // /3
  val result = fib.filter(_ % 3 == 0).take(10).toVector

  println("делятся на троечку:")
  result.foreach(println)
}
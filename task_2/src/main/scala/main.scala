object Main extends App {

  // первое задание - сумма через фолд
  def MySum(a: List[Int]): Int = {
    a.foldLeft(0)((acc, x) => acc + x)
  }

  // второе задание  - диапазон ркурсией
  def MyRange(n: Int, m: Int): List[Int] = (n, m) match {
    case (n, m) if n > m => Nil  // пустой если наоборот
    case (n, m) if n == m => List(n)
    case _ => n :: MyRange(n + 1, m)  // добавляю в голову и дальше
  }

  // првоерка, что работает
  println("Summa:")
  println(MySum(List(1, 2, 3, 4)))
  println(MySum(List(-2, 5, 0)))
  println(MySum(Nil)) // ноль, что логично

  println("\nRange:")
  println(MyRange(1, 5))
  println(MyRange(3, 3))
  println(MyRange(5, 1))
}
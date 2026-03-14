object Validators extends App {

  trait Validator[T] {
    def validate(v: T): Boolean
  }

  object Validator {
    // через лямбды
    implicit val strVal: Validator[String] = _.nonEmpty
    implicit val intVal: Validator[Int] = _ > 0
  }

  def check[T: Validator](v: T): Unit =
    println(if (implicitly[Validator[T]].validate(v)) "Оки" else "Ошибка!")

  
  implicit class ValidOps[T: Validator](v: T) {
    def isValid: Boolean = implicitly[Validator[T]].validate(v)
  }

  // простенький тест
  check("hello")
  check("")
  check(10)
  check(-5)

  println(s"abc valid? ${"abc".isValid}")
  println(s"42 valid? ${42.isValid}")
}
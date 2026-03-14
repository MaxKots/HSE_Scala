object NyamNyam extends App {

  case class User(id: Int, name: String)
  case class Order(userId: Int, amount: Double)

  // бд нет, ставлю заглушки
  def findUser(id: Int): Option[User] = id match {
    case 1 => Some(User(1, "Саня"))
    case 2 => Some(User(2, "Жорик"))
    case i => None
  }

  def getActiveOrder(u: User): Option[Order] = u.id match {
    case 1 => Some(Order(1, 1500))
    case 2 => Some(Order(2, 200))
    case _ => None
  }

  def calculateDiscount(o: Order): Either[String, Double] =
    if (o.amount < 500) Left("маловато для скидки")
    else Right(o.amount * 0.1)

  def getUserDiscount(userId: Int): Either[String, Double] = for {
    user <- findUser(userId).toRight("пользак не найден")
    order <- getActiveOrder(user).toRight("печаль, нет заказа")
    disc <- calculateDiscount(order)
  } yield disc

  // простенький тест
  List(1, 2, 3).foreach { id =>
    println(s"user $id -> ${getUserDiscount(id)}")
  }
}
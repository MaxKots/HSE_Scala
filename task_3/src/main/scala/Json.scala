import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Product(id: Long, name: String, price: Double, tags: List[String])

object Product {
  // dsl формат
  given Format[Product] = (
    (__ \ "id").format[Long] and
      (__ \ "name").format[String] and
      (__ \ "price").format[Double] and
      (__ \ "tags").format[List[String]]
    )(apply, prod => (prod.id, prod.name, prod.price, prod.tags))
}

@main def run() =
  import Product.given

  val src = """{"id":1,"name":"смартфон","price":19999.99,"tags":["техника","прочее"]}"""
  val item = Json.parse(src).as[Product]

  // + 10 %
  val expensive = item.copy(price = item.price * 1.1)

  println(s"до: $item")
  println(s"после: ${Json.toJson(expensive)}")
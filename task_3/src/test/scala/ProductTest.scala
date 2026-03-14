import play.api.libs.json._
import Product.given

class ProductTest extends munit.FunSuite {

  test("Тетсовый прогон") {
    val jsonStr = """{"id": 1, "name": "смартфон", "price": 19999.99, "tags": ["Техника", "прочее"]}"""

    val prod = Json.parse(jsonStr).as[Product]
    val withMarkup = prod.copy(price = prod.price * 1.1)
    val jsonBack = Json.stringify(Json.toJson(withMarkup))

    assertEquals(prod.id, 1L)
    assert(withMarkup.price > 1099.0)
    assert(jsonBack.contains("смартфон"))
  }
}
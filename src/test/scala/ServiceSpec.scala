import akka.http.scaladsl.model.ContentTypes._
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest._
import spray.json._

class ServiceSpec extends FlatSpec with Matchers with ScalatestRouteTest with Service {

  override def testConfigSource = "akka.loglevel = WARNING"

  "Service" should "respond with a greeting" in {
    Get(s"/hello/you") ~> routes ~> check {
      status shouldBe OK
      contentType shouldBe `application/json`
      responseAs[JsObject] shouldBe JsObject("greeting" -> JsString("Hello, you!"))
    }
  }

}

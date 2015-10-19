import Domain._
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.DefaultJsonProtocol

trait Protocols extends DefaultJsonProtocol with SprayJsonSupport {

  implicit val greetingFormat = jsonFormat1(Greeting.apply)

}

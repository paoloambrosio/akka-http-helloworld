import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.PathMatchers.Segment
import akka.stream.Materializer

import scala.concurrent.ExecutionContextExecutor

trait Service {

  implicit val system: ActorSystem
  implicit def executor: ExecutionContextExecutor
  implicit val materializer: Materializer

  val routes = {
    logRequestResult("akka-http") {
      pathPrefix("hello") {
        (get & path(Segment)) { name =>
          complete {
            s"Hello, $name!"
          }
        }
      }
    }
  }
}
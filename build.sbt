name         := "akka-http-helloworld"
organization := "net.paoloambrosio"
version      := "1.0"
scalaVersion := "2.11.7"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

libraryDependencies ++= {
  val akkaV       = "2.3.12" // Akka HTTP not ciplied with Akka 2.4
  val akkaStreamV = "1.0"
  val scalaTestV  = "2.2.5"
  Seq(
    "com.typesafe.akka" %% "akka-actor"                           % akkaV,
    "com.typesafe.akka" %% "akka-stream-experimental"             % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-core-experimental"          % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-experimental"               % akkaStreamV,
    "com.typesafe.akka" %% "akka-http-testkit-experimental"       % akkaStreamV,
    "org.scalatest"     %% "scalatest"                            % scalaTestV % "test"
  )
}

// http://www.scala-sbt.org/sbt-native-packager/formats/docker.html
// https://docs.docker.com/articles/dockerfile_best-practices/

enablePlugins(JavaServerAppPackaging)

maintainer in Docker := "Paolo Ambrosio <docker@paolo.ambrosio.name>"
packageSummary in Docker := "Hello World Application"
packageDescription := "Akka HTTP Hello World Application"
dockerExposedPorts := Seq(9000)
//dockerBaseImage := "dockerfile/java"
//dockerExposedVolumes := Seq("/opt/docker/logs")

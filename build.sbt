lazy val root =
  (project in file("."))
  .settings(
    name := "template",
    version := "1.0",
    scalaVersion := "2.11.7"
  ).settings(
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-http-core" % "2.4.3",
      "com.typesafe.akka" %% "akka-http-experimental" % "2.4.3",
      "org.scalatest" %% "scalatest" % "3.0.0-M15" % "test",
      "com.typesafe.akka" % "akka-http-testkit_2.11" % "2.4.3"
    )
  )

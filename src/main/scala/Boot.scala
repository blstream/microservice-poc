package com.blstream

import akka.actor.{ Actor, ActorSystem, Props }
import akka.util.ByteString
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ HttpEntity, ContentTypes }
import akka.stream.ActorMaterializer
import scala.util.Random
import scala.io.StdIn

object Boot
    extends Config
    with HealthCheck {

  def main(args: Array[String]): Unit = {

    implicit val system = ActorSystem("qiagen")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val route = health

    val bindingFuture = Http().bindAndHandle(route, "0.0.0.0", port)

    println(s"Server online at http://localhost:$port/\nPress RETURN to stop...")
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())

  }

}

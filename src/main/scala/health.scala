package com.blstream

import akka.http.scaladsl.model.{ HttpEntity, ContentTypes }
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

trait HealthCheck {
  lazy val health = path("health") {
    get {
      complete(HttpEntity(ContentTypes.`application/json`, "OK"))
    }
  }
}

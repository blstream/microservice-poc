package com.blstream

import org.scalatest.{ Matchers, WordSpec }
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.http.scaladsl.model.StatusCodes

class HealthSpec
    extends WordSpec
    with HealthCheck
    with Matchers
    with ScalatestRouteTest {

  "Health Service" should {
    "return health check informations" in {
      Get("/health") ~> health ~> check {
        status === StatusCodes.OK
      }
    }
  }
}

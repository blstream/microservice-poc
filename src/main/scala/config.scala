package com.blstream

trait Config {
  lazy val port = System.getenv("PORT").toInt
}

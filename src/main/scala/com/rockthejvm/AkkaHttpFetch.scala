package com.rockthejvm

import akka.actor.typed.ActorSystem
import akka.stream.ActorMaterializer

object AkkaHttpFetch {

    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()

  def main(args: Array[String]): Unit = {
    } 
}

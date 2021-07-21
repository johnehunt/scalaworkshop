package com.jjh.threading

import java.util.concurrent.{Callable, Executors}
import scala.util.{Failure, Random, Success, Try}

object CallableExample5 extends App {

  val callable = new Callable[Integer]() {
    override def call(): Integer = {
      Try {
        Thread.sleep(1000)
        new Random().nextInt(100)
      } match {
        case Success(value) => value
        case Failure(exp) => 42
      }
    }
  }

  val executor = Executors.newCachedThreadPool()

  val result = executor.submit(callable)
  println(result)
  println("Request value from result")
  println(result.get())
  print("Done")

  executor.shutdown()

}

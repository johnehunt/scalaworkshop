package com.jjh.threading

import java.util.concurrent.Executors

object ExecutorExample4 extends App {

  class RunnableTask(val message: String) extends Runnable {
    override def run() {
      while (true) {
        print(message)
      }
    }
  }

  val executor = Executors.newFixedThreadPool(3)
  executor.execute(new RunnableTask("A"))
  executor.execute(new RunnableTask("B"))
  executor.execute(new RunnableTask("C"))
  executor.execute(new RunnableTask("D"))

}

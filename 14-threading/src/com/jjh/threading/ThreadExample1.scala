package com.jjh.threading

object ThreadExample1 extends App {

  print("Starting")

  class SampleRunnable extends Runnable {
    override def run() {
      while (true) {
        print("A")
      }
    }
  }

  val t1 = new Thread(new SampleRunnable())
  t1.start()

  println("Done")

}

package com.jjh.threading

object ThreadExample2 extends App {

  class SampleThread extends Thread {
    override def run () {
      while (true) {
        print("A")
      }
    }
  }

  val t1 = new SampleThread()
  t1.start()

}

package com.jjh.threading

object Counter6 extends App {

  class Counter(var x: Int,
                var l: Long) {
    def increment(): Unit = x = x + 1
  }

  val c = new Counter(4, 5)
  c.increment()
  c.x = 14
  c.increment()
  c.l = 42L
  println(s"${c.x} - ${c.l}")

}

package com.jjh.threading

object SynchronizedExample8 extends App {

  class Counter(private var _x: Int,
                private var _l: Long) {

    def increment(): Unit = this.synchronized {
      _x = _x + 1
    }

    def x: Int = this.synchronized {
      _x
    }

    def x_=(i: Int): Unit = this.synchronized {
      _x = i
    }

    def l: Long = this.synchronized {
      _l
    }

    def l_=(value: Long): Unit = this.synchronized {
      _l = value
    }

  }

  val c = new Counter(4, 5)
  c.increment()
  c.x = 14
  c.increment()
  c.l = 42L
  println(s"${c.x} - ${c.l}")

}

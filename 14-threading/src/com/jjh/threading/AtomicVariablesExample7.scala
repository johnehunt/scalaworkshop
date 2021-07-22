package com.jjh.threading

import java.util.concurrent.atomic.{AtomicInteger, AtomicLong}

object AtomicVariablesExample7 extends App {

  class Counter(private var _x: AtomicInteger,
                private var _l: AtomicLong) {

    def increment(): Unit = _x.getAndIncrement()

    def x: Int = _x.get()
    def x_=(i: Int): Unit = _x.set(i)

    def l: Long = _l.get()
    def l_=(i: Long): Unit = _l.set(i)

  }

  object Counter {
    def apply(x: Int, l: Long) = new Counter(new AtomicInteger(x),
                                             new AtomicLong(l))
  }

  val c = Counter(4, 5)
  c.increment()
  c.x = 14
  c.increment()
  c.l = 42L
  println(s"${c.x} - ${c.l}")

}

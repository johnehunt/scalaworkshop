package com.jjh.scala.queue

object StackableTraitsTest2 extends App {
  val queue = new BasicIntQueue with Incrementing with Doubling
  queue.put(10)
  println(queue.get())
}

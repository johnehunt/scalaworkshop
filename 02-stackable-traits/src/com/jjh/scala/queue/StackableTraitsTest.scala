package com.jjh.scala.queue

object StackableTraitsTest extends App {
  val queue = new BasicIntQueue with Doubling
  queue.put(10)
  println(queue.get())
}

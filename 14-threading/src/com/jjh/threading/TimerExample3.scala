package com.jjh.threading

import java.text.SimpleDateFormat
import java.util.{Date, Timer, TimerTask}

object TimerExample3 extends App {

  val dateFormat =
    new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
  val timer = new Timer()
  val timerTask = new TimerTask() {
    override def run() {
      val timeStr = dateFormat.format(new Date())
      println(timeStr)
    }
  }

  timer.scheduleAtFixedRate(timerTask, 0, 1000); // every second from now

}

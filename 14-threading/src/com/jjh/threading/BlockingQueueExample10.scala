package com.jjh.threading

import java.text.SimpleDateFormat
import java.util.concurrent.{Executors, LinkedBlockingQueue}
import java.util.{Date, Timer, TimerTask}
import scala.util.{Failure, Try}

object BlockingQueueExample10 extends App {

  class LogWriter {
    final val messageQueue = new LinkedBlockingQueue[String]()

    def writeMessage(msg: String): Unit = {
      messageQueue.put(msg)
    }

    def logServer(): Unit = {
      Try {
        while (true) println(messageQueue.take())
      } match {
        case Failure(s) => println(s"Failed. Reason: $s")
      }
    }
  }

  // Create the logWriter
  val logWriter = new LogWriter()

  // Start up background thread to call logServer()
  val executors = Executors.newFixedThreadPool(1)
  executors.execute { () => logWriter.logServer() }

  // Now start up thread that will send a logging message every second
  val dateFormat =
    new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z")
  val timer = new Timer()
  val timerTask = new TimerTask() {
    override def run() {
      val timeStr = dateFormat.format(new Date())
      logWriter.writeMessage(timeStr)
    }
  }

  timer.scheduleAtFixedRate(timerTask, 0, 1000); // every second from now


}

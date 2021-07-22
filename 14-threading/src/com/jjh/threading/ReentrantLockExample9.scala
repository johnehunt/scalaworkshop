package com.jjh.threading

import java.util.concurrent.Executors
import java.util.concurrent.locks.ReentrantLock
import scala.io.StdIn.readLine
import scala.util.{Random, Try}

object ReentrantLockExample9 extends App {

  val count = 3
  val executors = Executors.newFixedThreadPool(count)

  class Worker {

    private val lock = new ReentrantLock()
    private val random = new Random(100)

    def doWork(msg: String): Int = {
      lock.lock()

      val t = Try {
        Thread.sleep(100)
        print(msg)
        random.nextInt()
      }

      lock.unlock()
      t.get
    }

  }

  val worker = new Worker()

  executors.execute{ () =>
    1 to 10 foreach{ _ => worker.doWork("A")}
  }
  executors.execute{ () =>
    1 to 15 foreach{ _ => worker.doWork("B")}
  }
  executors.execute{ () =>
    1 to 5 foreach{ _ => worker.doWork("C")}
  }

  println("Press return to exit")
  readLine()

  executors.shutdown()
  println("Done")
}

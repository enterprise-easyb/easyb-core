package org.disco.bdd.behavior.queue

import org.disco.bdd.Queue

before "initialize the queue for each spec", {
  queue = new Queue()
}

it "should dequeue item just enqueued", {
  queue.enqueue(2)
  queue.dequeue().shouldBe(2)
}

it "should throw an exception when null is enqueued", {
  ensureThrows(RuntimeException.class) {
    queue.enqueue(null)
  }
}

it "should dequeue items in same order enqueued", {
  [1..5].each {val ->
    queue.enqueue(val)
  }
  [1..5].each {val ->
    queue.dequeue().shouldBe(val)
  }
}
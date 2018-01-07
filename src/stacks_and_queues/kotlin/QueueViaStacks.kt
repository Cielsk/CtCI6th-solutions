package stacks_and_queues.kotlin

import java.util.*

/**
 *
 */
fun main(args: Array<String>) {
    val queue = MyQueue()
    (0..10).forEach { queue.add(it) }

    println(queue.peek())   // expect 0
    println()
    while (!queue.isEmpty()) {
        println(queue.remove())
    }
}

class MyQueue {
    private val inStack = Stack<Int>()
    private val outStack = Stack<Int>()

    fun add(element: Int) {
        inStack.push(element)
    }

    fun remove(): Int {
        inToOut()
        return outStack.pop()
    }

    fun peek(): Int {
        inToOut()
        return outStack.peek()
    }

    private fun inToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop())
        }
    }

    fun isEmpty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }
}
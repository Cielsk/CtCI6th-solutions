package stacks_and_queues.kotlin

import java.util.*

/**
 *
 */
fun main(args: Array<String>) {
    val stack = MinStack()

    stack.push(3)
    stack.push(5)
    stack.push(1)
    stack.push(4)
    stack.push(2)
    println(stack.min)
}

class MinStack {
    val stack = Stack<Int>()
    var min = Int.MAX_VALUE

    fun push(element: Int) {
        min = Integer.min(element, min)
        stack.push(element)
    }

    fun isEmpty(): Boolean {
        return stack.isEmpty()
    }

    fun peek(): Int {
        return stack.peek()
    }

    fun pop(): Int {
        return stack.pop()
    }

    fun min(): Int {
        if (isEmpty()) throw StackUnderFlowException()
        return min
    }
}
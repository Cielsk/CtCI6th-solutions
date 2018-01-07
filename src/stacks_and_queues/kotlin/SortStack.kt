package stacks_and_queues.kotlin

import java.util.*

/**
 *
 */
fun main(args: Array<String>) {
    val stack = Stack<Int>()
    stack.push(5)
    stack.push(1)
    stack.push(3)
    stack.push(2)
    stack.push(4)

    sort(stack)
    while (!stack.isEmpty()) {
        println(stack.pop())
    }
}

fun sort(stack: Stack<Int>) {
    val buf = Stack<Int>()

    while (!stack.isEmpty()) {
        val top = stack.pop()

        while (!buf.isEmpty() && buf.peek() > top) {
            stack.push(buf.pop())
        }

        buf.push(top)
    }
    while (!buf.isEmpty()) {
        stack.push(buf.pop())
    }
}
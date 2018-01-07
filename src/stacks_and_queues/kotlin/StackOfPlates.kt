package stacks_and_queues.kotlin

import java.util.*
import java.util.stream.Collectors

/**
 *
 */
fun main(args: Array<String>) {
    val stacks = SetOfStacks(5)

    (0..19).forEach { stacks.push(it) }
    stacks.printStacks()

    stacks.popAt(0)
    stacks.popAt(2)
    stacks.popAt(2)
    stacks.printStacks()
}

private class SetOfStacks(private val threshold: Int) {
    private val stacks: MutableList<Stack<Int>>

    fun isEmpty(): Boolean {
        if (stacks.size == 0) {
            return true
        }

        return stacks.none { it.size > 0 }
    }

    init {
        stacks = ArrayList()
    }

    fun push(element: Int) {
        val size = stacks.size
        if (size == 0 || stacks[size - 1].size >= threshold) {
            val stack = Stack<Int>()
            stack.push(element)
            stacks.add(stack)
        } else {
            stacks[size - 1].push(element)
        }
    }

    fun popAt(index: Int): Int {
        if (index < 0 || index >= stacks.size) {
            throw IllegalArgumentException("There is no stack at index " + index)
        }
        val stack = stacks[index]
        if (stack.isEmpty()) {
            throw StackUnderFlowException()
        }

        return stack.pop()
    }

    fun pop(): Int {
        if (isEmpty()) {
            throw StackUnderFlowException()
        }

        val size = stacks.size
        clear()
        (size - 1 downTo 0)
                .filterNot { stacks[it].isEmpty() }
                .forEach { return stacks[it].pop() }

        return 0
    }

    fun peek(): Int {
        if (isEmpty()) {
            throw StackUnderFlowException()
        }

        val size = stacks.size

        return (size - 1 downTo 0)
                       .firstOrNull { !stacks[it].isEmpty() }
                       ?.let { stacks[it].peek() }
               ?: stacks[0].peek()
    }

    private fun clear() {
        stacks.removeIf({ it.isEmpty() })
    }

    fun printStacks() {
        if (isEmpty()) {
            println("{}")
        }
        val builder = StringBuilder()
        builder.append("{\n")

        val content = stacks.stream().map({ this.stackToString(it) }).collect(Collectors.joining(", \n"))
        builder.append(content)

        builder.append("\n}")
        println(builder.toString())
    }

    private fun stackToString(stack: Stack<Int>): String {
        return "[" + stack.stream().map({ it.toString() }).collect(Collectors.joining(", ")) + "]"
    }
}
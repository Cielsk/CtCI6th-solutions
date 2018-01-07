package stacks_and_queues.kotlin

import java.util.*
import java.util.stream.Collectors

/**
 *
 */
fun main(args: Array<String>) {
    val stack = ThreeStack(5)

    stack.push(0, 1)
    stack.push(1, 2)
    stack.push(2, 3)
    stack.push(0, 4)
    stack.push(0, 5)
    stack.push(0, 6)
    stack.push(1, 7)
    stack.push(1, 8)
    stack.push(2, 9)

    println(stack.peek(0))  // expect 6
    println(stack.peek(1))  // expect 8
    println(stack.peek(2))  // expect 9

    stack.printStack(0)  // expect [1, 4, 5, 6]
    stack.printStack(1)  // expect [2, 7, 8]
    stack.printStack(2)  // expect [3, 9]

    stack.pop(0)
    stack.pop(1)
    stack.pop(2)

    println(stack.peek(0))  // expect 5
    println(stack.peek(1))  // expect 7
    println(stack.peek(2))  // expect 3

    stack.printStack(0)  // expect [1, 4, 5]
    stack.printStack(1)  // expect [2, 7]
    stack.printStack(2)  // expect [3]
}

class ThreeStack(private val capacity: Int) {
    private val data: IntArray = IntArray(3 * capacity)
    private val sizes: IntArray = IntArray(3)

    fun push(num: Int, element: Int) {
        if (!isValidNum(num)) throw IllegalArgumentException("There is no stack with serial number " + num)

        if (sizes[num] == capacity) throw StackOverFlowException()

        data[getIndexToPush(num)] = element
        sizes[num]++
    }

    fun pop(num: Int): Int {
        if (!isValidNum(num)) throw IllegalArgumentException("There is no stack with serial number " + num)

        if (isEmpty(num)) throw StackUnderFlowException()

        val re = data[getIndexToPush(num) - 1]
        sizes[num]--
        return re
    }

    fun peek(num: Int): Int {
        if (!isValidNum(num)) throw IllegalArgumentException("There is no stack with serial number " + num)

        if (isEmpty(num)) throw StackUnderFlowException()

        return data[getIndexToPush(num) - 1]
    }

    private fun getIndexToPush(num: Int) = capacity * num + sizes[num]

    private fun isValidNum(num: Int) = num in 0..2

    fun isEmpty(num: Int) = sizes[num] == 0

    fun printStack(num: Int) {
        val content = Arrays.stream(data, capacity * num, getIndexToPush(num)).mapToObj(Int::toString).collect(Collectors.joining(", "))
        println("[$content]")
    }
}
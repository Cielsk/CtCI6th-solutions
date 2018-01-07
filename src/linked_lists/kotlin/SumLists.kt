package linked_lists.kotlin

import java.math.BigInteger
import java.util.*

/**
 *
 */
fun main(args: Array<String>) {
    val list1 = initLinkedList(getLength())
    println("Linked list1:")
    printLinkedList(list1)
    println("Integer value of list1 is:" + convert(list1))

    val list2 = initLinkedList(getLength())
    println("Linked list2:")
    printLinkedList(list2)
    println("Integer value of list2 is:" + convert(list2))

    val list = sum(list1, list2)
    println("Sum of list1 and list2 is:" + convert(list))
}

fun getLength(): Int = Random().nextInt(10) + 1


fun sum(head1: Node, head2: Node): Node {
    var h1 = head1 as? Node
    var h2 = head2 as? Node

    var carry = 0
    var head: Node? = null
    var tail: Node? = null

    while (true) {
        var d1 = 0
        var d2 = 0
        if (h1 != null) {
            d1 = h1.data
            h1 = h1.next
        }
        if (h2 != null) {
            d2 = h2.data
            h2 = h2.next
        }

        val digit = carry + d1 + d2
        if (digit == 0) break

        carry = if (digit > 10) 1 else 0
        val temp = Node()
        temp.data = if (digit > 10) digit - 10 else digit

        if (tail != null) {
            tail.next = temp
        } else {
            head = temp
        }
        tail = temp
    }

    return head!!
}

fun convert(head: Node?): BigInteger {
    if (head == null) return BigInteger.ZERO

    var ptr = head as? Node
    val builder = StringBuilder()
    while (ptr != null) {
        builder.append(ptr.data)
        ptr = ptr.next
    }

    return BigInteger(builder.reverse().toString())
}
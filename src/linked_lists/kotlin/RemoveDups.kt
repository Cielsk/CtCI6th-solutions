package linked_lists.kotlin

import java.util.*

/**
 *
 */
fun main(args: Array<String>) {
    println("Linked list:")
    val list = initLinkedList(10)
    printLinkedList(list)

    println("List without duplicates:")
    removeDups(list)
    printLinkedList(list)
}

val digitUpperBound = 10

class Node {
    var data: Int = 0
    var next: Node? = null
}

fun initLinkedList(n: Int): Node {
    val random = Random()
    val head = Node()
    head.data = random.nextInt(digitUpperBound)
    var ptr = head
    for (i in 1..n) {
        val temp = Node()
        temp.data = random.nextInt(digitUpperBound)
        ptr.next = temp
        ptr = temp
    }
    return head
}

fun printLinkedList(head: Node) {
    print("[")
    print(head.data)
    var ptr = head.next
    while (ptr != null) {
        print(", " + ptr.data)
        ptr = ptr.next
    }
    println("]")
}

fun removeDups(head: Node) {
    var ptr = head as? Node
    while (ptr != null) {
        var prev = ptr
        var cur = ptr.next
        while (cur != null) {
            if (cur.data == ptr.data) {
                prev?.next = cur.next
            } else {
                prev = cur
            }
            cur = cur.next
        }

        ptr = ptr.next
    }
}
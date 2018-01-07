package linked_lists.kotlin

/**
 *
 */
fun main(args: Array<String>) {
    val list1 = arrayToLinkedList(intArrayOf(1, 2, 3, 4, 5))
    var tail = list1
    while (tail?.next != null) {
        tail = tail.next
    }

    tail?.next = list1?.next?.next

    val entrance = list1?.let { loopEntrance(it) }
    println("Entrance of loop is " + entrance?.data) // expect 3

    tail?.next = null
}

fun loopEntrance(list: Node): Node? {
    var fast = list as? Node
    var slow = list as? Node
    var hasLoop = false
    while (fast != null && fast.next != null) {
        fast = fast.next!!.next
        slow = slow!!.next

        if (slow == fast) {
            hasLoop = true
            break
        }
    }

    if (!hasLoop) return null

    slow = list
    while (slow != fast) {
        slow = slow?.next
        fast = fast?.next
    }

    return slow
}
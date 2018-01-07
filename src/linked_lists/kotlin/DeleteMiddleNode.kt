package linked_lists.kotlin

/**
 *
 */
fun main(args: Array<String>) {
    test(9)
    test(10)
}

fun test(n: Int) {
    val list = initLinkedList(n)
    println("Linked list:")
    printLinkedList(list)

    println("List after deleting middle node:")
    deleteMid(list)
    printLinkedList(list)
}

fun deleteMid(head: Node) {
    if (head.next == null || head.next!!.next == null) throw IllegalArgumentException(
            "List is too short.")
    var prev = head
    var slow = head
    var fast = head.next!!.next
    while (fast != null) {
        prev = slow
        slow = slow.next!!
        if (fast.next == null) break
        fast = fast.next!!.next
    }
    prev.next = slow.next
}
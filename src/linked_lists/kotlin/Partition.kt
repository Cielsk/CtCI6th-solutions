package linked_lists.kotlin

/**
 *
 */
fun main(args: Array<String>) {
    println("Linked list:")
    val list = initLinkedList(10)
    printLinkedList(list)

    println("Input the number:")
    val n = readLine().toString().toInt()
    println("List after partition:")
    printLinkedList(partition(list, n))
}

fun partition(head: Node, x: Int): Node {
    var h = head
    var prev = head
    var ptr = head.next
    while (ptr != null) {
        if (ptr.data < x) {
            prev.next = ptr.next
            ptr.next = h
            h = ptr
            ptr = prev.next
        } else {
            prev = ptr
            ptr = ptr.next
        }
    }

    return h
}
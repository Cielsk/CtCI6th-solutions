package linked_lists.kotlin

/**
 *
 */
fun main(args: Array<String>) {
    val list = initLinkedList(10)
    println("Linked list:")
    printLinkedList(list)

    println("Input the number:")
    val k = readLine().toString().toInt()
    println("The element is " + kthToLast(list, k).data)
}

fun kthToLast(head: Node, k: Int): Node {
    var fast = head as? Node
    for (i in 1..k) {
        if (fast == null) throw IllegalArgumentException("List is too short.")
        fast = fast.next
    }
    var slow = head as? Node
    while (fast != null) {
        slow = slow!!.next
        fast = fast.next
    }

    return slow!!
}
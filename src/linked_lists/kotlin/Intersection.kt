package linked_lists.kotlin

import kotlin.math.abs
import kotlin.math.max

/**
 *
 */
fun main(args: Array<String>) {
    var list1 = arrayToLinkedList(intArrayOf(1, 2, 3))
    var list2 = arrayToLinkedList(intArrayOf(11, 22))
    val common = arrayToLinkedList(intArrayOf(4, 5, 6))
    if (list1 != null && list2 != null && common != null) {
        list1 = concat(list1, common)
        list2 = concat(list2, common)

        println("Method 1 (find circle):")
        var node = intersection(list1, list2)
        println(if (node == null) "No intersection" else "Data of intersection node is " + node.data)

        println("Method 2 (hash set):")
        node = intersectionHashSet(list1, list2)
        println(if (node == null) "No intersection" else "Data of intersection node is " + node.data)

        println("Method 3 (alignment):")
        node = intersectionAlignment(list1, list2)
        println(if (node == null) "No intersection" else "Data of intersection node is " + node.data)
    }
}

fun concat(head1: Node, head2: Node): Node {
    var ptr = head1
    while (ptr.next != null) {
        ptr = ptr.next!!
    }
    ptr.next = head2
    return head1
}

fun intersection(list1: Node, list2: Node): Node? {
    var ptr = list1 as? Node
    while (ptr != null && ptr.next != null) {
        ptr = ptr.next
    }
    val tail = ptr

    tail!!.next = list2
    var fast = list1 as? Node
    ptr = list1
    while (fast != null && fast.next != null) {
        fast = fast.next!!.next
        ptr = ptr!!.next

        if (ptr == fast) break
    }
    ptr = list1
    while (ptr != null && fast != null) {
        if (ptr == fast) break
        ptr = ptr.next
        fast = fast.next
    }

    tail.next = null
    return ptr
}

fun intersectionHashSet(list1: Node, list2: Node): Node? {
    val set = HashSet<Node>()
    var ptr = list1 as? Node
    while (ptr != null) {
        set.add(ptr)
        ptr = ptr.next
    }
    ptr = list2
    while (ptr != null) {
        if (set.contains(ptr)) return ptr
        ptr = ptr.next
    }

    return null
}

fun intersectionAlignment(list1: Node, list2: Node): Node? {
    val len1 = getLength(list1)
    val len2 = getLength(list2)

    var shortList: Node? = if (len1 < len2) list1 else list2
    var longList: Node? = if (len1 < len2) list2 else list1
    val len = max(len1, len2)
    val dis = abs(len2 - len1)
    for (i in 1..len) {
        longList = longList!!.next
        if (i in 1..dis) continue
        shortList = shortList!!.next

        if (longList == shortList) return shortList
    }

    return null
}

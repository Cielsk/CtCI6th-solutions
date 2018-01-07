package linked_lists.kotlin

/**
 *
 */
fun main(args: Array<String>) {
    testPalindrome(intArrayOf(1, 2, 3, 4, 3, 2, 1))
    testPalindrome(intArrayOf(1))
    testPalindrome(intArrayOf(1, 2, 3, 3, 2, 1))
    testPalindrome(intArrayOf(1, 2, 3, 4))
}

private fun testPalindrome(arr: IntArray) {
    val delimiter = String(CharArray(20, { '-' }))
    println(delimiter)
    println()

    println("Linked list:")
    val list = arrayToLinkedList(arr)
    list?.let {
        printLinkedList(it)

        print("Result of normal method:")
        println(if (isPalindrome(list)) "Palindrome" else "Not palindrome")

        print("Result of recursive method:")
        println(if (isPalindromeRecursive(list)) "Palindrome" else "Not palindrome")
    }
    println()
}

private class Result(val node: Node, val isPalindrome: Boolean)

fun isPalindromeRecursive(list: Node): Boolean {
    val length = getLength(list)
    return isPalindromeRecur(list, length).isPalindrome
}

fun getLength(list: Node): Int {
    var length = 0
    var ptr = list as? Node
    while (ptr != null) {
        length++
        ptr = ptr.next
    }
    return length
}

private fun isPalindromeRecur(list: Node, length: Int): Result {
    if (length == 1) {
        return Result(list, true)
    }
    if (length == 2) {
        return Result(list.next!!, true)
    }

    val subListResult = isPalindromeRecur(list.next!!, length - 2)
    val tail = subListResult.node.next!!
    if (!subListResult.isPalindrome) return Result(tail, false)
    return Result(tail, tail.data == list.data)
}

fun isPalindrome(head: Node): Boolean {
    val rev = reversedList(head)
    return isEqual(head, rev)
}

fun reversedList(head: Node): Node? {
    var re: Node? = null
    var ptr = head as? Node
    while (ptr != null) {
        val temp = Node()
        temp.data = ptr.data
        temp.next = re
        re = temp
        ptr = ptr.next
    }
    return re
}

fun isEqual(head1: Node?, head2: Node?): Boolean {
    var ptr1 = head1
    var ptr2 = head2
    while (ptr1 != null && ptr2 != null) {
        if (ptr1.data != ptr2.data) return false

        ptr1 = ptr1.next
        ptr2 = ptr2.next
    }

    return ptr1 == null && ptr2 == null
}

fun arrayToLinkedList(arr: IntArray): Node? {
    var head: Node? = null
    for (i in arr.reversedArray()) {
        val temp = Node()
        temp.data = i
        temp.next = head
        head = temp
    }

    return head
}
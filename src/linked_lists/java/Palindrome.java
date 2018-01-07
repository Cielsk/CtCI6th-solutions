package linked_lists.java;

import static linked_lists.java.Node.printLinkedList;

import java.util.Arrays;

/**
 *
 */
public class Palindrome {

  public static void main(String[] args) {
    test(new int[]{1, 2, 3, 4, 3, 2, 1});
    test(new int[]{1});
    test(new int[]{1, 2, 2, 1});
    test(new int[]{1, 2, 3, 4});
  }

  private static void test(int[] arr) {
    char[] chars = new char[20];
    Arrays.fill(chars, '-');
    String delimiter = String.valueOf(chars);
    System.out.println(delimiter);
    System.out.println();

    System.out.println("Linked list:");
    Node list = arrayToLinkedList(arr);
    printLinkedList(list);

    System.out.print("Result of normal method:");
    System.out.println(isPalindrome(list) ? "Palindrome" : "Not palindrome");

    System.out.print("Result of recursive method:");
    System.out.println(isPalindromeRecursive(list) ? "Palindrome" : "Not palindrome");
    System.out.println();
  }

  private static boolean isPalindrome(Node head) {
    Node rev = reversedList(head);
    return isEqual(head, rev);
  }

  private static Node reversedList(Node head) {
    Node re = null;
    for (Node ptr = head; ptr != null; ptr = ptr.next) {
      Node temp = new Node();
      temp.data = ptr.data;
      temp.next = re;
      re = temp;
    }

    return re;
  }

  /*
   * Assume that two lists do NOT have circles.
   */
  private static boolean isEqual(Node head1, Node head2) {
    while (head1 != null && head2 != null) {
      if (head1.data != head2.data) {
        return false;
      }
      head1 = head1.next;
      head2 = head2.next;
    }

    return head1 == null && head2 == null;
  }

  static Node arrayToLinkedList(int[] arr) {
    if (arr.length == 0) {
      return null;
    }

    Node head = null;
    for (int i = arr.length - 1; i >= 0; i--) {
      Node temp = new Node();
      temp.data = arr[i];
      temp.next = head;
      head = temp;
    }

    return head;
  }

  private static boolean isPalindromeRecursive(Node head) {
    int len = getLength(head);
    return isPalindromeRecursive(head, len).isPalindrome;
  }

  static int getLength(Node head) {
    Node ptr = head;
    int  len = 0;
    while (ptr != null) {
      len++;
      ptr = ptr.next;
    }
    return len;
  }

  private static Result isPalindromeRecursive(Node head, int len) {
    if (len == 1) {
      return new Result(head, true);
    }
    if (len == 2) {
      return new Result(head.next, true);
    }

    Result subListResult = isPalindromeRecursive(head.next, len - 2);

    Node tail = subListResult.node.next;
    if (!subListResult.isPalindrome) {
      return new Result(tail, false);
    }

    return new Result(tail, tail.data == head.data);
  }

  /*
   * Store recursive method result, especially for node to store the tail node of sublist.
   */
  private static class Result {

    Node    node;
    boolean isPalindrome;

    Result(Node node, boolean isPalindrome) {
      this.node = node;
      this.isPalindrome = isPalindrome;
    }
  }
}

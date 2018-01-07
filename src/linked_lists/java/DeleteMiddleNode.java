package linked_lists.java;

import static linked_lists.java.Node.printLinkedList;
import static linked_lists.java.RemoveDups.initLinkedList;

/**
 *
 */
public class DeleteMiddleNode {

  public static void main(String[] args) {
    test(9);
    test(10);
  }

  private static void test(int n) {
    Node list = initLinkedList(n);
    System.out.println("Linked list:");
    printLinkedList(list);

    System.out.println("List after deleting middle node:");
    deleteMid(list);
    printLinkedList(list);
  }

  private static Node deleteMid(Node head) {
    if (head == null) {
      throw new IllegalArgumentException("Null linked list.");
    }

    Node slow = head;
    if (head.next == null || head.next.next == null) {
      throw new IllegalArgumentException("List is too short.");
    }
    Node prev = null;
    Node fast = head.next.next;
    while (fast != null) {
      prev = slow;
      slow = slow.next;
      if (fast.next == null) {
        break;
      }
      fast = fast.next.next;
    }
    prev.next = slow.next;

    return head;
  }
}

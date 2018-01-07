package linked_lists.java;

import static linked_lists.java.Palindrome.arrayToLinkedList;

/**
 *
 */
public class LoopDetection {

  public static void main(String[] args) {
    final Node list = arrayToLinkedList(new int[]{1, 2, 3, 4, 5});
    if (list == null) {
      return;
    }

    Node tail = list;
    while (tail.next != null) {
      tail = tail.next;
    }
    tail.next = list.next.next;

    Node entrance = loopEntrance(list);
    if (entrance != null) {
      System.out.println("Entrance of loop is " + entrance.data); // expect 3
    }
    tail.next = null;
  }

  private static Node loopEntrance(Node head) {
    Node    fast    = head;
    Node    slow    = head;
    boolean hasLoop = false;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;

      if (slow == fast) {
        hasLoop = true;
        break;
      }
    }

    if (!hasLoop) {
      return null;
    }
    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    return slow;
  }
}

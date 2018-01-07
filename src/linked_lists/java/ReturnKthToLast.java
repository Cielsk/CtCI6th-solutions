package linked_lists.java;

import static linked_lists.java.Node.printLinkedList;
import static linked_lists.java.RemoveDups.initLinkedList;

import java.util.Scanner;

/**
 *
 */
public class ReturnKthToLast {

  public static void main(String[] args) {
    Node list = initLinkedList(10);
    System.out.println("Linked list:");
    printLinkedList(list);

    System.out.println("Input the number:");
    Scanner in = new Scanner(System.in);
    int     n  = in.nextInt();
    System.out.printf("The element is %d.", kthToLast(list, n).data);
  }

  private static Node kthToLast(Node head, int k) {
    if (head == null) {
      throw new IllegalArgumentException("Null linked list.");
    }

    Node fast = head;
    for (int i = 0; i < k; i++, fast = fast.next) {
      if (fast == null) {
        throw new IllegalArgumentException("List too short for index " + k);
      }
    }

    Node slow = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    return slow;
  }
}

package linked_lists.java;

import static linked_lists.java.Node.printLinkedList;
import static linked_lists.java.RemoveDups.initLinkedList;

import java.util.Scanner;

/**
 *
 */
public class Partition {

  public static void main(String[] args) {
    Node list = initLinkedList(10);
    System.out.println("Linked list:");
    printLinkedList(list);

    System.out.println("Input an integer:");
    Scanner in = new Scanner(System.in);
    int     n  = in.nextInt();
    System.out.println("List after partition:");
    printLinkedList(partition(list, n));
  }

  private static Node partition(Node head, int x) {
    if (head == null) {
      return null;
    }

    Node prev = head;
    Node ptr  = head.next;
    while (ptr != null) {
      if (ptr.data < x) {
        prev.next = ptr.next;

        ptr.next = head;
        head = ptr;

        ptr = prev.next;
      } else {
        prev = ptr;
        ptr = ptr.next;
      }
    }

    return head;
  }
}

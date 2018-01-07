package linked_lists.java;

import static linked_lists.java.Node.printLinkedList;

import java.util.Random;

/**
 *
 */
public class RemoveDups {

  private static final int MAX = 10;

  public static void main(String[] args) {
    Node list = initLinkedList(10);
    System.out.println("List source:");
    printLinkedList(list);

    System.out.println("List after removing duplicates:");
    printLinkedList(removeDups(list));
  }

  static Node initLinkedList(int n) {
    if (n == 0) {
      return null;
    }

    Random random = new Random();
    Node   head   = new Node();
    head.data = random.nextInt(MAX);
    Node ptr = head;
    for (int i = 1; i < n; i++) {
      Node temp = new Node();
      temp.data = random.nextInt(MAX);
      ptr.next = temp;
      ptr = temp;
    }

    return head;
  }

  private static Node removeDups(Node head) {
    for (Node ptr = head; ptr != null; ptr = ptr.next) {
      // remove duplicates of ptr.data
      Node prev = ptr;
      Node cur  = ptr.next;
      while (cur != null) {
        if (cur.data == ptr.data) {
          prev.next = cur.next;
        } else {
          prev = cur;
        }
        cur = cur.next;
      }
    }

    return head;
  }
}

class Node {

  int  data;
  Node next;

  static void printLinkedList(Node head) {
    System.out.print("[");

    if (head != null) {
      System.out.print(head.data);
      for (head = head.next; head != null; head = head.next) {
        System.out.printf(", %d", head.data);
      }
    }

    System.out.println("]");
  }
}

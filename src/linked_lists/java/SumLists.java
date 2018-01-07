package linked_lists.java;

import static linked_lists.java.Node.printLinkedList;
import static linked_lists.java.RemoveDups.initLinkedList;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 */
public class SumLists {

  public static void main(String[] args) {
    Node list1 = initLinkedList(getLength());
    System.out.println("Linked list1:");
    printLinkedList(list1);
    System.out.println("Integer value of list1 is:" + convert(list1));

    Node list2 = initLinkedList(getLength());
    System.out.println("Linked list2:");
    printLinkedList(list2);
    System.out.println("Integer value of list1 is:" + convert(list2));

    Node list = sum(list1, list2);
    System.out.println("Sum of list1 and list2 is:" + convert(list));
  }

  private static int getLength() {
    return new Random().nextInt(10) + 1;
  }

  private static Node sum(Node head1, Node head2) {
    if (head2 == null) {
      return head1;
    }
    if (head1 == null) {
      return head2;
    }

    Node head  = null;
    Node tail  = null;
    int  carry = 0;

    while (true) {
      int d1 = 0;
      int d2 = 0;
      if (head1 != null) {
        d1 = head1.data;
        head1 = head1.next;
      }
      if (head2 != null) {
        d2 = head2.data;
        head2 = head2.next;
      }
      int digit = carry + d1 + d2;
      if (digit == 0) {
        break;
      }

      carry = digit > 10 ? 1 : 0;
      Node temp = new Node();
      temp.data = digit > 10 ? digit - 10 : digit;

      if (tail != null) {
        tail.next = temp;
      } else {
        head = temp;
      }

      tail = temp;
    }

    return head;
  }

  private static BigInteger convert(Node head) {
    if (head == null) {
      return BigInteger.ZERO;
    }

    StringBuilder builder = new StringBuilder();
    while (head != null) {
      builder.append(head.data);
      head = head.next;
    }

    return new BigInteger(builder.reverse().toString());
  }
}

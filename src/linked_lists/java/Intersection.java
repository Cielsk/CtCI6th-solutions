package linked_lists.java;

import static linked_lists.java.Palindrome.arrayToLinkedList;
import static linked_lists.java.Palindrome.getLength;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class Intersection {

  public static void main(String[] args) {
    Node list1  = arrayToLinkedList(new int[]{1, 2, 3});
    Node list2  = arrayToLinkedList(new int[]{11, 22});
    Node common = arrayToLinkedList(new int[]{4, 5, 6});
    list1 = concat(list1, common);
    list2 = concat(list2, common);

    System.out.println("Method 1 (find circle):");
    Node node = intersection(list1, list2);
    System.out.println(
        node == null ? "No intersection" : "Data of intersection node is " + node.data);

    System.out.println("Method 2 (hash set):");
    node = intersectionHashSet(list1, list2);
    System.out.println(
        node == null ? "No intersection" : "Data of intersection node is " + node.data);

    System.out.println("Method 3 (alignment):");
    node = intersectionAlignment(list1, list2);
    System.out.println(
        node == null ? "No intersection" : "Data of intersection node is " + node.data);

    // There are also other methods, such as using two stacks.
  }

  private static Node concat(Node head1, Node head2) {
    if (head1 == null) {
      return head2;
    }
    Node ptr = head1;
    while (ptr.next != null) {
      ptr = ptr.next;
    }
    ptr.next = head2;
    return head1;
  }

  private static Node intersection(Node head1, Node head2) {
    if (head1 == null || head2 == null) {
      return null;
    }

    Node ptr = head1;
    while (ptr.next != null) {
      ptr = ptr.next;
    }
    final Node tail1 = ptr;

    /* only one node in list1 */
    if (tail1 == head1) {
      return head1 == head2 ? head1 : null;
    }

    tail1.next = head2;

    /* find the entrance of circle in list1 */
    ptr = head1;
    Node fast = head1;
    while (fast != null && fast.next != null) {
      ptr = ptr.next;
      fast = fast.next.next;

      if (ptr == fast) {
        break; // list1 has a circle
      }
    }
    ptr = head1;
    while (ptr != fast) {
      ptr = ptr.next;
      assert fast != null;
      fast = fast.next;
    }
    tail1.next = null;

    return ptr;
  }

  private static Node intersectionHashSet(Node head1, Node head2) {
    Set<Node> set = new HashSet<>();
    for (Node ptr = head1; ptr != null; ptr = ptr.next) {
      set.add(ptr);
    }
    for (Node ptr = head2; ptr != null; ptr = ptr.next) {
      if (set.contains(ptr)) {
        return ptr;
      }
    }
    return null;
  }

  private static Node intersectionAlignment(Node head1, Node head2) {
    int  len1      = getLength(head1);
    int  len2      = getLength(head2);
    Node shortList = len1 < len2 ? head1 : head2;
    Node longList  = len1 < len2 ? head2 : head1;

    int len = Math.max(len1, len2);
    int dis = Math.abs(len2 - len1);
    for (int i = 0; i < len; i++) {
      longList = longList.next;
      if (i < dis) {
        continue;
      }

      shortList = shortList.next;
      if (shortList == longList) {
        return shortList;
      }
    }

    return null;
  }
}

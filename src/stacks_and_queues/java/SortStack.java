package stacks_and_queues.java;

import java.util.Stack;

/**
 *
 */
public class SortStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(5);
    stack.push(1);
    stack.push(3);
    stack.push(2);
    stack.push(4);

    sort(stack);
    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  private static void sort(Stack<Integer> stack) {
    Stack<Integer> buf = new Stack<>();

    while (!stack.isEmpty()) {
      int top = stack.pop();

      while (!buf.isEmpty() && buf.peek() > top) {
        stack.push(buf.pop());
      }

      buf.push(top);
    }
    while (!buf.isEmpty()) {
      stack.push(buf.pop());
    }
  }
}

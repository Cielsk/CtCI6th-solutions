package stacks_and_queues.java;

import java.util.Stack;

/**
 *
 */
public class StackMin {

  public static void main(String[] args) {
    MinStack stack = new MinStack();

    stack.push(3);
    stack.push(5);
    stack.push(1);
    stack.push(4);
    stack.push(2);
    System.out.println(stack.min);
  }

  static class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private int            min   = Integer.MAX_VALUE;

    void push(int element) {
      min = Integer.min(element, min);
      stack.push(element);
    }

    boolean isEmpty() {
      return stack.isEmpty();
    }

    int peek() {
      return stack.peek();
    }

    int pop() {
      return stack.pop();
    }

    int min() {
      if (isEmpty()) {
        throw new StackUnderFlowException();
      }
      return min;
    }
  }
}

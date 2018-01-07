package stacks_and_queues.java;

import java.util.Stack;
import java.util.stream.IntStream;

/**
 *
 */
public class QueueViaStacks {

  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    IntStream.range(0, 10).forEach(queue::add);

    System.out.println(queue.peek());   // expect 0
    System.out.println();
    while (!queue.isEmpty()) {
      System.out.println(queue.remove());
    }
  }

  static class MyQueue {

    private final Stack<Integer> in  = new Stack<>();
    private final Stack<Integer> out = new Stack<>();

    void add(int element) {
      in.push(element);
    }

    int remove() {
      inToOut();
      return out.pop();
    }

    int peek() {
      inToOut();
      return out.peek();
    }

    private void inToOut() {
      while (!in.isEmpty()) {
        out.push(in.pop());
      }
    }

    boolean isEmpty() {
      return in.isEmpty() && out.isEmpty();
    }
  }
}

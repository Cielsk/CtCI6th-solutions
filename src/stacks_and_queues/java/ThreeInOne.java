package stacks_and_queues.java;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 *
 */
public class ThreeInOne {

  public static void main(String[] args) throws StackOverFlowException {
    ThreeStack stack = new ThreeStack(5);

    stack.push(0, 1);
    stack.push(1, 2);
    stack.push(2, 3);
    stack.push(0, 4);
    stack.push(0, 5);
    stack.push(0, 6);
    stack.push(1, 7);
    stack.push(1, 8);
    stack.push(2, 9);

    System.out.println(stack.peek(0));  // expect 6
    System.out.println(stack.peek(1));  // expect 8
    System.out.println(stack.peek(2));  // expect 9

    stack.printStack(0);  // expect [1, 4, 5, 6]
    stack.printStack(1);  // expect [2, 7, 8]
    stack.printStack(2);  // expect [3, 9]

    stack.pop(0);
    stack.pop(1);
    stack.pop(2);

    System.out.println(stack.peek(0));  // expect 5
    System.out.println(stack.peek(1));  // expect 7
    System.out.println(stack.peek(2));  // expect 3

    stack.printStack(0);  // expect [1, 4, 5]
    stack.printStack(1);  // expect [2, 7]
    stack.printStack(2);  // expect [3]
  }

  static class ThreeStack {

    private final int[] data;
    private final int   capacity;
    private final int[] sizes = new int[3];

    ThreeStack(int capacity) {
      this.capacity = capacity;
      data = new int[3 * capacity];
    }

    private boolean isValidNum(int n) {
      return n >= 0 && n < 3;
    }

    void push(int num, int element) throws StackOverFlowException {
      if (!isValidNum(num)) {
        throw new IllegalArgumentException("There is no stack with serial number " + num);
      }

      if (sizes[num] == capacity) {
        throw new StackOverFlowException();
      }

      data[getIndexToPush(num)] = element;
      sizes[num]++;
    }

    private int getIndexToPush(int num) {
      return capacity * num + sizes[num];
    }

    boolean isEmpty(int num) {
      if (!isValidNum(num)) {
        throw new IllegalArgumentException("There is no stack with serial number " + num);
      }

      return sizes[num] == 0;
    }

    int pop(int num) {
      if (!isValidNum(num)) {
        throw new IllegalArgumentException("There is no stack with serial number " + num);
      }

      if (isEmpty(num)) {
        throw new StackUnderFlowException();
      }

      int re = data[getIndexToPush(num) - 1];
      sizes[num]--;
      return re;
    }

    int peek(int num) {
      if (!isValidNum(num)) {
        throw new IllegalArgumentException("There is no stack with serial number " + num);
      }

      if (isEmpty(num)) {
        throw new StackUnderFlowException();
      }

      return data[getIndexToPush(num) - 1];
    }

    void printStack(int num) {
      if (!isValidNum(num)) {
        throw new IllegalArgumentException("There is no stack with serial number " + num);
      }

      String content = Arrays.stream(data, capacity * num, getIndexToPush(num))
          .mapToObj(Integer::toString)
          .collect(Collectors.joining(", "));
      System.out.println("[" + content + "]");
    }
  }
}

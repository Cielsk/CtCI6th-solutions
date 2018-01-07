package stacks_and_queues.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 *
 */
public class StackOfPlates {

  public static void main(String[] args) {
    SetOfStacks stacks = new SetOfStacks(5);

    for (int i = 0; i < 20; i++) {
      stacks.push(i);
    }
    stacks.printStacks();

    stacks.popAt(0);
    stacks.popAt(2);
    stacks.popAt(2);
    stacks.printStacks();
  }

  static class SetOfStacks {

    private final int                  threshold;
    private final List<Stack<Integer>> stacks;

    SetOfStacks(int threshold) {
      this.threshold = threshold;
      stacks = new ArrayList<>();
    }

    void push(int element) {
      int size = stacks.size();
      if (size == 0 || stacks.get(size - 1).size() >= threshold) {
        Stack<Integer> stack = new Stack<>();
        stack.push(element);
        stacks.add(stack);
      } else {
        stacks.get(size - 1).push(element);
      }
    }

    int popAt(int index) {
      if (index < 0 || index >= stacks.size()) {
        throw new IllegalArgumentException("There is no stack at index " + index);
      }
      Stack<Integer> stack = stacks.get(index);
      if (stack.isEmpty()) {
        throw new StackUnderFlowException();
      }

      return stack.pop();
    }

    int pop() {
      if (isEmpty()) {
        throw new StackUnderFlowException();
      }

      int size = stacks.size();
      for (int i = size - 1; i >= 0; i--) {
        if (stacks.get(i).isEmpty()) {
          continue;
        }
        return stacks.get(i).pop();
      }

      clear();
      return 0;
    }

    int peek() {
      if (isEmpty()) {
        throw new StackUnderFlowException();
      }

      int size = stacks.size();
      for (int i = size - 1; i >= 0; i--) {
        if (stacks.get(i).isEmpty()) {
          continue;
        }
        return stacks.get(i).peek();
      }

      return stacks.get(0).peek();
    }

    boolean isEmpty() {
      return stacks.size() == 0 || stacks.stream().allMatch(Stack::isEmpty);
    }

    private void clear() {
      stacks.removeIf(Stack::isEmpty);
    }

    void printStacks() {
      if (isEmpty()) {
        System.out.println("{}");
      }
      StringBuilder builder = new StringBuilder();
      builder.append("{\n");

      String content = stacks.stream().map(this::stackToString).collect(Collectors.joining(", \n"));
      builder.append(content);

      builder.append("\n}");
      System.out.println(builder.toString());
    }

    private String stackToString(Stack<Integer> stack) {
      return "[" + stack.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]";
    }
  }
}

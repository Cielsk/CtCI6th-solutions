package stacks_and_queues.java;

/**
 *
 */
class StackUnderFlowException extends RuntimeException {

  StackUnderFlowException() {
    super("Stack underflow.");
  }
}

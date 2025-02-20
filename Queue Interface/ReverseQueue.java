import java.util.*;
public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
    // Reverse queue using stack
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        // Step 1: Dequeue all elements into the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        // Step 2: Push elements back from stack to queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}

import java.util.Stack;
public class SortStackRecursively {
    // Function to sort a stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            // Remove the top element
            int top = stack.pop();
            // Recursively sort the remaining stack
            sortStack(stack);
            // Insert the popped element back in sorted order
            insertInSortedOrder(stack, top);
        }
    }
    // Helper function to insert an element in a sorted manner
    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        // If stack is empty or the element is greater than the top, push it
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }
        // Remove the top element and recurse
        int top = stack.pop();
        insertInSortedOrder(stack, element);
        // Push the top element back after inserting the new element
        stack.push(top);
    }
    // Helper function to print the stack
    private static void printStack(Stack<Integer> stack) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        System.out.println("Original Stack:");
        printStack(stack);
        sortStack(stack);
        System.out.println("Sorted Stack:");
        printStack(stack);
    }
}

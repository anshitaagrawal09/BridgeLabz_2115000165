import java.util.Stack;
public class StockSpan {
    // Function to calculate the stock span for each day
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>(); // Stores indices
        for (int i = 0; i < n; i++) {
            // Pop elements from stack while stack is not empty and stack top is <= current price
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }
            // If stack is empty, all previous prices were smaller -> span = i + 1
            span[i] = (stack.isEmpty()) ? (i + 1) : (i - stack.peek());
            // Push current index to stack
            stack.push(i);
        }
        return span;
    }
    // Helper function to print an array
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
    
        System.out.println("Stock Prices:");
        printArray(prices);
        int[] span = calculateSpan(prices);
        System.out.println("Stock Span:");
        printArray(span);
    }
}

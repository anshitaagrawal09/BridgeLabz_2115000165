public class FibonacciComparison {
    public static void main(String[] args) {
        int[] testValues = {10, 30, 50};
        for (int n : testValues) {
            System.out.println("Fibonacci(" + n + ")");
            // Recursive Approach (O(2^N))
            long startTime = System.nanoTime();
            int recursiveResult = fibonacciRecursive(n);
            long recursiveTime = System.nanoTime() - startTime;
            // Iterative Approach (O(N))
            startTime = System.nanoTime();
            int iterativeResult = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - startTime;
            System.out.println("Recursive Result: " + recursiveResult + " | Time: " + (recursiveTime / 1_000_000.0) + " ms");
            System.out.println("Iterative Result: " + iterativeResult + " | Time: " + (iterativeTime / 1_000_000.0) + " ms");
            System.out.println("-----------------------------------");
        }
    }
    // Exponential Time Complexity (O(2^N))
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    // Linear Time Complexity (O(N))
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

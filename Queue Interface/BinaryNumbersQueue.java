import java.util.*;
public class BinaryNumbersQueue {
    public static void main(String[] args) {
        int N = 5;  // Number of binary numbers to generate
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println(binaryNumbers);
    }
    public static List<String> generateBinaryNumbers(int N) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");  // Start with "1"
        for (int i = 0; i < N; i++) {
            String binary = queue.remove(); // Dequeue the front element
            result.add(binary); // Store the result
            queue.add(binary + "0"); // Generate the next two numbers
            queue.add(binary + "1");
        }
        return result;
    }
}

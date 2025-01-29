import java.util.Scanner;
public class FibonacciSequenceGenerator {
    public static void main(String[] args) {
        int terms = getInput("Enter the number of terms for the Fibonacci sequence: ");
        generateFibonacci(terms);
    }
    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    public static void generateFibonacci(int terms) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Sequence: ");
        for (int i = 1; i <= terms; i++) {
            System.out.print(a + " ");
            int nextTerm = a + b;
            a = b;
            b = nextTerm;
        }
        System.out.println();
    }
}

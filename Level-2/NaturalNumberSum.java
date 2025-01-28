
import java.util.Scanner;
public class NaturalNumberSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a valid natural number.");
            return;
        }
        int recursiveSum = sumUsingRecursion(n);
        int formulaSum = sumUsingFormula(n);
        System.out.println("Sum using recursion: " + recursiveSum);
        System.out.println("Sum using formula: " + formulaSum);
        if (recursiveSum == formulaSum) {
            System.out.println("Both results are correct!");
        } else {
            System.out.println("There is an error in the computation.");
        }
    }
    public static int sumUsingRecursion(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sumUsingRecursion(n - 1);
        }
    }
    public static int sumUsingFormula(int n) {
        return (n * (n + 1)) / 2;
    }
}


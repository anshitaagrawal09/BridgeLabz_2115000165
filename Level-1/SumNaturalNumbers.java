
import java.util.Scanner;
public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            int sumUsingFormula = n * (n + 1) / 2;
            int sumUsingWhileLoop = 0;
            int counter = 1;
            while (counter <= n) {
                sumUsingWhileLoop += counter;
                counter++;
            }
            System.out.println("Sum using formula: " + sumUsingFormula);
            System.out.println("Sum using while loop: " + sumUsingWhileLoop);
            if (sumUsingFormula == sumUsingWhileLoop) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is an error in the computations.");
            }
        }
    }
}


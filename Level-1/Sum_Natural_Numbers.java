
import java.util.Scanner;
public class Sum_Natural_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            int sumUsingFormula = n * (n + 1) / 2;
            int sumUsingForLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumUsingForLoop += i;
            }
            System.out.println("Sum using formula: " + sumUsingFormula);
            System.out.println("Sum using for loop: " + sumUsingForLoop);
            if (sumUsingFormula == sumUsingForLoop) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is an error in the computations.");
            }
        }
    }
}


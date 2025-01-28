
import java.util.Scanner;
public class FactorCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int[] factors = findFactors(number);
        System.out.print("Factors of " + number + ": ");
        for (int factor : factors) {
            if (factor != 0) {
                System.out.print(factor + " ");
            }
        }
        System.out.println();
        System.out.println("Sum of factors: " + sumOfFactors(factors));
        System.out.println("Sum of square of factors: " + sumOfSquareOfFactors(factors));
        System.out.println("Product of factors: " + productOfFactors(factors));
    }
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            if (factor != 0) {
                sum += factor;
            }
        }
        return sum;
    }
    public static double sumOfSquareOfFactors(int[] factors) {
        double sumOfSquares = 0;
        for (int factor : factors) {
            if (factor != 0) {
                sumOfSquares += Math.pow(factor, 2);
            }
        }
        return sumOfSquares;
    }
    public static long productOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors) {
            if (factor != 0) {
                product *= factor;
            }
        }
        return product;
    }
}


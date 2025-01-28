
import java.util.Scanner;
public class NumberCheck {
    public static String isPositive(int number) {
        if (number < 0) {
            return "Negative";
        }
        return "Positive";
    }
    public static String isEven(int number) {
        if (number % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }
    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 == number2) {
            return 0;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        for (int i = 0; i < 5; i++) {
            String result = isPositive(numbers[i]);
            System.out.print("Number " + (i + 1) + " is " + result + " ");
            if (result.equals("Positive")) {
                System.out.println(isEven(numbers[i]));
            } else {
                System.out.println();
            }
        }
        int compareResult = compare(numbers[0], numbers[4]);
        if (compareResult == 1) {
            System.out.println("First number is greater than last number.");
        } else if (compareResult == 0) {
            System.out.println("First number is equal to last number.");
        } else {
            System.out.println("First number is less than last number.");
        }
        scanner.close();
    }
}


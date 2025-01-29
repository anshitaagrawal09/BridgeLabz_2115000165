import java.util.Scanner;
public class FactorialUsingRecursion {
    public static void main(String[] args) {
        int number = getInput("Enter a number to calculate its factorial: ");
        long factorial = calculateFactorial(number);
        displayResult("The factorial of " + number + " is: " + factorial);
    }
    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    public static long calculateFactorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * calculateFactorial(num - 1);
        }
    }
    public static void displayResult(String result) {
        System.out.println(result);
    }
}

import java.util.Scanner;
public class GCDandLCMCalculator {
    public static void main(String[] args) {
        int num1 = getInput("Enter the first number: ");
        int num2 = getInput("Enter the second number: ");
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2, gcd);
        displayResult("The GCD of " + num1 + " and " + num2 + " is: " + gcd);
        displayResult("The LCM of " + num1 + " and " + num2 + " is: " + lcm);
    }
    public static int getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextInt();
    }
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int calculateLCM(int a, int b, int gcd) {
        return (a * b) / gcd;
    }
    public static void displayResult(String result) {
        System.out.println(result);
    }
}

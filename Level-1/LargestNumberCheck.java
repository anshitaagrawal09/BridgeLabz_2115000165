import java.util.Scanner;
public class LargestNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int number1 = scanner.nextInt();
        System.out.print("Enter the second number: ");
        int number2 = scanner.nextInt();
        System.out.print("Enter the third number: ");
        int number3 = scanner.nextInt();
        if (number1 > number2 && number1 > number3) {
            System.out.println("Is the first number the largest? true");
        } else {
            System.out.println("Is the first number the largest? false");
        }
        if (number2 > number1 && number2 > number3) {
            System.out.println("Is the second number the largest? true");
        } else {
            System.out.println("Is the second number the largest? false");
        }
        if (number3 > number1 && number3 > number2) {
            System.out.println("Is the third number the largest? true");
        } else {
            System.out.println("Is the third number the largest? false");
        }
    }
}


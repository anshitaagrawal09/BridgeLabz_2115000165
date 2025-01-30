import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        scanner.close();
        boolean isPalindrome = true;
        int length = input.length();
        for (int i = 0; i < length / 2; i++) {
            char start = input.charAt(i);
            char end = input.charAt(length - 1 - i);
            if (start >= 'A' && start <= 'Z') {
                start = (char) (start + 'a' - 'A');
            }
            if (end >= 'A' && end <= 'Z') {
                end = (char) (end + 'a' - 'A');
            }
            if (start != end) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}


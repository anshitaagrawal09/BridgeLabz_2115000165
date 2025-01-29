import java.util.Scanner;
public class PalindromeChecker {
    public static void main(String[] args) {
        String input = getInput("Enter a string to check if it's a palindrome: ");
        if (isPalindrome(input)) {
            displayResult(input + " is a palindrome.");
        } else {
            displayResult(input + " is not a palindrome.");
        }
    }
    public static String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("[^a-zA-Z]", "").toLowerCase();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void displayResult(String result) {
        System.out.println(result);
    }
}

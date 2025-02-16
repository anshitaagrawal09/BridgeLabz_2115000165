import java.util.HashSet;
import java.util.Scanner;
public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!seen.contains(ch)) {  // If character is not already added
                sb.append(ch);         // Append to StringBuilder
                seen.add(ch);          // Mark character as seen
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String result = removeDuplicates(input);
        System.out.println("String without duplicates: " + result);
        scanner.close();
    }
}

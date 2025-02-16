import java.util.Scanner;
public class StringConcatenation {
    public static String concatenateStrings(String[] words) {
        StringBuffer sb = new StringBuffer(); 
        for (String word : words) {
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of words: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }
        String result = concatenateStrings(words);
        System.out.println("Concatenated String:" + result);
        scanner.close();
    }
}

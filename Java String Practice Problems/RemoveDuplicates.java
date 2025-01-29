import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        String result = "";
        for (char ch : input.toCharArray()) {
            if (result.indexOf(ch) == -1) result += ch;
        }
        System.out.println("String after removing duplicates: " + result);
        scanner.close();
    }
}


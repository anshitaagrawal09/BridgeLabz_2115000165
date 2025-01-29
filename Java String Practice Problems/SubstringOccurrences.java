import java.util.Scanner;
public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String mainString = scanner.nextLine();
        System.out.print("Enter the substring: ");
        String subString = scanner.nextLine();
        int count = 0, index = 0;
        while ((index = mainString.indexOf(subString, index)) != -1) {
            count++;
            index += subString.length();
        }
        System.out.println("Occurrences of substring: " + count);
        scanner.close();
    }
}


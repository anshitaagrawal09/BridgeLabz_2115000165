import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Take input from the user
        System.out.print("Enter the number of elements in the list: ");
        int n = scanner.nextInt();
        List<Integer> inputList = new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for (int i = 0; i < n; i++) {
            inputList.add(scanner.nextInt());
        }
        inputList.add(155);
        // Remove duplicates while preserving order
        List<Integer> outputList = new ArrayList<>();
        for (Integer item : inputList) {
            if (!outputList.contains(item)) {
                outputList.add(item);
            }
        }
        // Print the result
        System.out.println("List after removing duplicates: " + outputList);
        scanner.close();
    }
}
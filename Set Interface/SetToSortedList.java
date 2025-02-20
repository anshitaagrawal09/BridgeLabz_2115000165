import java.util.*;
public class SetToSortedList {
    public static void main(String[] args) {
        // Create a HashSet of integers
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);
        // Convert to sorted list
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); // Sort in ascending order
        // Print the sorted list
        System.out.println("Sorted List: " + sortedList); // Output: [1, 3, 5, 9]
    }
}

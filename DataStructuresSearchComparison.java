import java.util.*;
public class DataStructuresSearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 100000, 1000000}; // Different dataset sizes
        for (int size : sizes) {
            System.out.println("Dataset Size: " + size);
            // Generate random dataset
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                int value = random.nextInt(size * 10); // Ensure unique large range values
                array[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }
            int target = array[size / 2]; // Choose a middle value as the search target
            // Array Search (O(N))
            long startTime = System.nanoTime();
            linearSearch(array, target);
            long arraySearchTime = System.nanoTime() - startTime;
            // HashSet Search (O(1))
            startTime = System.nanoTime();
            boolean hashSetContains = hashSet.contains(target);
            long hashSetSearchTime = System.nanoTime() - startTime;
            // TreeSet Search (O(log N))
            startTime = System.nanoTime();
            boolean treeSetContains = treeSet.contains(target);
            long treeSetSearchTime = System.nanoTime() - startTime;
            // Display results
            System.out.println("Array Search Time: " + (arraySearchTime / 1_000_000.0) + " ms");
            System.out.println("HashSet Search Time: " + (hashSetSearchTime / 1_000_000.0) + " ms");
            System.out.println("TreeSet Search Time: " + (treeSetSearchTime / 1_000_000.0) + " ms");
            System.out.println("-----------------------------------");
        }
    }
    // Linear Search (O(N))
    public static boolean linearSearch(int[] array, int target) {
        for (int num : array) {
            if (num == target) return true;
        }
        return false;
    }
}

import java.util.HashSet;
import java.util.Set;
public class SetOperations {
    public static void main(String[] args) {
        // Define two sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        // Compute Union
        Set<Integer> unionSet = new HashSet<>(set1); // Copy set1
        unionSet.addAll(set2); // Add all elements from set2
        System.out.println("Union: " + unionSet); // Output: {1, 2, 3, 4, 5}
        // Compute Intersection
        Set<Integer> intersectionSet = new HashSet<>(set1); // Copy set1
        intersectionSet.retainAll(set2); // Retain only common elements
        System.out.println("Intersection: " + intersectionSet); // Output: {3}
    }
}

import java.util.HashSet;
import java.util.Set;
public class SymmetricDifference {
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
        // Compute Symmetric Difference
        Set<Integer> symmetricDiff = symmetricDifference(set1, set2);
        System.out.println("Symmetric Difference: " + symmetricDiff); // Output: {1, 2, 4, 5}
    }
    public static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2); // Union of both sets
        Set<Integer> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2); // Intersection of both sets
        unionSet.removeAll(intersectionSet); // Remove common elements
        return unionSet;
    }
}

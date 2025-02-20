import java.util.HashSet;
import java.util.Set;
public class SubsetCheck {
    public static void main(String[] args) {
        // Define two sets
        Set<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(3);
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        // Check if set1 is a subset of set2
        boolean isSubset = set2.containsAll(set1);
        System.out.println("Is Set1 a subset of Set2? " + isSubset); // Output: true
    }
}

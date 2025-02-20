import java.util.*;
public class MaxValueKeyFinder {
    public static void main(String[] args) {
        // Input Map<String, Integer>
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        // Find key with the highest value
        String maxKey = getMaxValueKey(map);
        // Output result
        System.out.println("Key with the highest value: " + maxKey);
    }
    public static String getMaxValueKey(Map<String, Integer> map) {
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }
        return maxKey;
    }
}

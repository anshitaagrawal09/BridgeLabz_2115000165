import java.util.*;
public class InvertMap {
    public static void main(String[] args) {
        // Input Map<K, V>
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);
        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);
        // Print the result
        System.out.println("Inverted Map: " + invertedMap);
    }
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> map) {
        Map<V, List<K>> invertedMap = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();
            // If value already exists, add to the list; otherwise, create a new list
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }
        return invertedMap;
    }
}

import java.util.LinkedList;
class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    // Entry class to store key-value pairs
    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    // Constructor
    public CustomHashMap() {
        this.buckets = new LinkedList[DEFAULT_CAPACITY];
        this.size = 0;
    }
    // Hash function
    private int getBucketIndex(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % buckets.length;
    }
    // Insert or update a key-value pair
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;  // Update value if key exists
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
    }
    // Retrieve a value by key
    public V get(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null; // Key not found
    }
    // Remove a key-value pair
    public void remove(K key) {
        int index = getBucketIndex(key);
        if (buckets[index] != null) {
            for (Entry<K, V> entry : buckets[index]) {
                if (entry.key.equals(key)) {
                    buckets[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }
    // Check if the map contains a key
    public boolean containsKey(K key) {
        return get(key) != null;
    }
    // Get the number of key-value pairs
    public int size() {
        return size;
    }
    // Print the HashMap (for debugging)
    public void printMap() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + " -> " + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 35);
        map.put("Alice", 28);  // Update Alice's age
        System.out.println("Alice's age: " + map.get("Alice")); // Output: 28
        System.out.println("Contains Bob? " + map.containsKey("Bob")); // Output: true
        map.remove("Bob");
        System.out.println("Contains Bob after removal? " + map.containsKey("Bob")); // Output: false
        System.out.println("Size of HashMap: " + map.size()); // Output: 2
        map.printMap();  // Prints the current state of the hashmap
    }
}

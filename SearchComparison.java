import java.util.Arrays;
import java.util.Random;
public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random random = new Random();
        for (int size : sizes) {
            int[] data = generateRandomArray(size);
            int target = data[random.nextInt(size)]; // Random target from the array(from 0 to size-1)
            // Linear Search
            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;
            // Sort for Binary Search
            Arrays.sort(data);
            // Binary Search
            startTime = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - startTime;
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + (linearTime / 1_000_000.0) + " ms");
            System.out.println("Binary Search Time: " + (binaryTime / 1_000_000.0) + " ms");
            System.out.println("-----------------------------------");
        }
    }
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10); // Generating random numbers
        }
        return array;
    }
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}

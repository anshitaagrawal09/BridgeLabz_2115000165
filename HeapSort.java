import java.util.*;
public class HeapSort {
    // Function to perform heap sort
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // Step 1: Build a Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i); // Swap root (max) with last element
            heapify(arr, i, 0); // Heapify the reduced heap
        }
    }
    // Heapify function to maintain max heap property
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize root as largest
        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2; // Right child index
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    // Utility function to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Main function to test sorting
    public static void main(String[] args) {
        int[] salaries = {50000, 70000, 40000, 60000, 80000, 45000};
        System.out.println("Before Sorting: " + Arrays.toString(salaries));
        heapSort(salaries);
        System.out.println("After Sorting: " + Arrays.toString(salaries));
    }
}

import java.util.*;
public class InsertionSort {
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;
            // Move elements that are greater than key to one position ahead
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {15, 13, 2, 27, 5};
        insertionSort(employeeIDs);
        System.out.println(Arrays.toString(employeeIDs));
    }
}

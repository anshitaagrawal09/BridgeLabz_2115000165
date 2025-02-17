import java.util.Arrays;
import java.util.Random;

public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random random = new Random();
        for (int size : sizes) {
            int[] data = generateRandomArray(size);
            // Bubble Sort (Inefficient for large data)
            int[] bubbleArray = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            bubbleSort(bubbleArray);
            long bubbleTime = System.nanoTime() - startTime;

            // Merge Sort (O(N log N))
            int[] mergeArray = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            mergeSort(mergeArray, 0, mergeArray.length - 1);
            long mergeTime = System.nanoTime() - startTime;

            // Quick Sort (O(N log N))
            int[] quickArray = Arrays.copyOf(data, data.length);
            startTime = System.nanoTime();
            quickSort(quickArray, 0, quickArray.length - 1);
            long quickTime = System.nanoTime() - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Bubble Sort Time: " + (bubbleTime / 1_000_000.0) + " ms");
            System.out.println("Merge Sort Time: " + (mergeTime / 1_000_000.0) + " ms");
            System.out.println("Quick Sort Time: " + (quickTime / 1_000_000.0) + " ms");
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

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] a = new int[1];
			a[0] = arr[lo];
			return a;
		}

		int mid = (lo + hi) / 2;

		int[] fs = mergeSort(arr, lo, mid);
		int[] ss = mergeSort(arr, mid + 1, hi);
		return Merge_TwoSorted_Array(fs, ss);

	}

	public static int[] Merge_TwoSorted_Array(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[] ans = new int[n + m];
		int i = 0;// arr1
		int j = 0;// arr2
		int k = 0;// ans

		while (i < n && j < m) {

			if (arr1[i] <= arr2[j]) {
				ans[k] = arr1[i];
				k++;
				i++;
			} else {
				ans[k] = arr2[j];
				j++;
				k++;
			}

		}
		while (i < n) {
			ans[k] = arr1[i];
			k++;
			i++;
		}

		while (j < m) {
			ans[k] = arr2[j];
			j++;
			k++;
		}
		return ans;

	}

    public static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int idx = Partition(arr, lo, hi);
		quickSort(arr, lo, idx - 1);
		quickSort(arr, idx + 1, hi);

	}

	public static int Partition(int[] arr, int lo, int hi) {

		int pivot = arr[hi];
		int idx = lo;
		for (int i = lo; i < hi; i++) {
			if (arr[i] <= pivot) {
				// i , idx

				int t = arr[i];
				arr[i] = arr[idx];
				arr[idx] = t;
				idx++;
			}

		}
		// idx hi

		int t = arr[idx];
		arr[idx] = arr[hi];
		arr[hi] = t;
		return idx;

	}
}

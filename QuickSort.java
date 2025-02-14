import java.util.*;
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {900, 300, 800, 1500, 350, 100};
		QuickSort(prices, 0, prices.length - 1);
        System.out.println(Arrays.toString(prices));

	}

	public static void QuickSort(int[] arr, int lo, int hi) {
		if (lo >= hi) {
			return;
		}

		int idx = Partition(arr, lo, hi);
		QuickSort(arr, lo, idx - 1);
		QuickSort(arr, idx + 1, hi);

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
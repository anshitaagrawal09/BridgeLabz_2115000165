import java.util.Arrays;
public class SearchChallenge {
    // Function to find the first missing positive integer using linear search
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        // Place each number at its correct index if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // Find the first missing positive number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1; // If all numbers are present, return next positive integer
    }
    // Function to perform binary search on a sorted array
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid; // Found target, return index
            } else if (nums[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Target not found
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1, 5};
        // Find the first missing positive integer
        int missing = findFirstMissingPositive(nums);
        System.out.println("First Missing Positive Integer: " + missing);
        // Sort array for binary search
        Arrays.sort(nums);
        System.out.println("Sorted Array: " + Arrays.toString(nums));
        // Perform binary search
        int target = 4;
        int index = binarySearch(nums, target);
        System.out.println("Index of Target (" + target + "): " + index);
    }
}

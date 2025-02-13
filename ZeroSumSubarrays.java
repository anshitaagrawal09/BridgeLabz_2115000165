import java.util.*;
public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] nums) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;
        // Initialize with sum = 0 at index -1 for subarrays starting from index 0
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // If the sum has been seen before, subarrays exist with zero sum
            if (sumMap.containsKey(sum)) {
                for (int startIndex : sumMap.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }
            // Add the current index to the sumMap
            sumMap.putIfAbsent(sum, new ArrayList<>());
            sumMap.get(sum).add(i);
        }
        return result;
    }
    // Helper function to print subarrays
    public static void printSubarrays(List<int[]> subarrays) {
        for (int[] subarray : subarrays) {
            System.out.println("Subarray found from index " + subarray[0] + " to " + subarray[1]);
        }
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<int[]> subarrays = findZeroSumSubarrays(nums);
        if (subarrays.isEmpty()) {
            System.out.println("No zero-sum subarrays found.");
        } else {
            printSubarrays(subarrays);
        }
    }
}

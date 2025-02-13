import java.util.HashMap;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // If complement exists, return the pair of indices
            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            // Store the number and its index
            numMap.put(nums[i], i);
        }
        return new int[]{}; // No solution found
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result.length == 2) {
            System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("No valid pair found.");
        }
    }
}

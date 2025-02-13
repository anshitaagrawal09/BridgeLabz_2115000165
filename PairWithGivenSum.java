import java.util.HashMap;
public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashMap<Integer, Boolean> numMap = new HashMap<>();
        for (int num : nums) {
            int complement = target - num;
            // If the complement exists, we found a pair
            if (numMap.containsKey(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }
            // Store the current number
            numMap.put(num, true);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {10, 15, 3, 7};
        int target = 17;
        if (!hasPairWithSum(nums, target)) {
            System.out.println("No pair found.");
        }
    }
}

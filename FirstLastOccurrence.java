public class FirstLastOccurrence {
    public static int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1, first = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                first = mid; // Possible first occurrence
                right = mid - 1; // Continue searching left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return first;
    }
    public static int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1, last = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                last = mid; // Possible last occurrence
                left = mid + 1; // Continue searching right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return last;
    }
    public static int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        int[] nums = {2, 4, 4, 4, 5, 6, 7, 8, 8, 10};
        int target = 4;
        int[] result = searchRange(nums, target);
        System.out.println("First Occurrence: " + result[0] + ", Last Occurrence: " + result[1]);
        target = 8;
        result = searchRange(nums, target);
        System.out.println("First Occurrence: " + result[0] + ", Last Occurrence: " + result[1]);
        target = 3;
        result = searchRange(nums, target);
        System.out.println("First Occurrence: " + result[0] + ", Last Occurrence: " + result[1]);
    }
}

public class RotationPointSearch {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // If mid element is greater than the last element, the rotation point is in the right half
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else { 
                // Otherwise, the rotation point is in the left half (including mid)
                right = mid;
            }
        }
        return left; // Index of the smallest element (rotation point)
    }
    public static void main(String[] args) {
        int[] rotatedArray = {7, 8, 9, 1, 2, 3, 4, 5, 6}; // Example rotated sorted array
        int rotationIndex = findRotationPoint(rotatedArray);
        System.out.println("Rotation point index: " + rotationIndex);
        System.out.println("Smallest element: " + rotatedArray[rotationIndex]);
    }
}

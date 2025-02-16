public class PeakElementSearch {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // If mid element is smaller than the next element, the peak is on the right side
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // Otherwise, the peak is on the left side (or mid itself is a peak)
                right = mid;
            }
        }
        return left; // Index of any peak element found
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 20, 4, 1, 0}; // Example array
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element: " + arr[peakIndex]);
    }
}

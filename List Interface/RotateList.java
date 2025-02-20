import java.util.*;
public class RotateList {
    public static void rotateList(List<Integer> list, int positions) {
        int size = list.size();
        positions = positions % size; // Handle cases where positions > size
        // Create a new list for rotated elements
        List<Integer> temp = new ArrayList<>();
        // Copy elements after the rotation point
        for (int i = positions; i < size; i++) {
            temp.add(list.get(i));
        }
        // Copy the first 'positions' elements to the end
        for (int i = 0; i < positions; i++) {
            temp.add(list.get(i));
        }
        // Copy back to original list
        for (int i = 0; i < size; i++) {
            list.set(i, temp.get(i));
        }
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int rotateBy = 2;
        rotateList(list, rotateBy);
        // Print rotated list
        System.out.println("Rotated List: " + list);
    }
}



















// import java.util.*;
// public class RotateList {
//     public static void rotateList(List<Integer> list, int positions) {
//         int size = list.size();
//         positions = positions % size; // Handle cases where positions > size
//         // Create a new list with rotated elements
//         List<Integer> rotatedList = new ArrayList<>();
//         rotatedList.addAll(list.subList(positions, size)); // Add elements from 'positions' to end
//         rotatedList.addAll(list.subList(0, positions)); // Add first 'positions' elements to the end
//         System.out.println("Rotated List: " + rotatedList);
//     }
//     public static void main(String[] args) {
//         List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
//         int rotateBy = 2;
//         rotateList(list, rotateBy);
//     }
// }

// import java.util.*;
// public class RotateList {
//     public static void rotateList(int[] arr, int positions) {
//         int size = arr.length;
//         positions = positions % size; // Handle cases where positions > size
//         // Temporary array to store rotated values
//         int[] temp = new int[size];
//         // Copy elements after rotation point
//         int index = 0;
//         for (int i = positions; i < size; i++) {
//             temp[index++] = arr[i];
//         }
//         // Copy first 'positions' elements to end
//         for (int i = 0; i < positions; i++) {
//             temp[index++] = arr[i];
//         }
//         // Copy temp back to original array
//         for (int i = 0; i < size; i++) {
//             arr[i] = temp[i];
//         }
//     }

//     public static void main(String[] args) {
//         int[] arr = {10, 20, 30, 40, 50};
//         int rotateBy = 2;
//         rotateList(arr, rotateBy);
//         // Print rotated list
//         System.out.print("Rotated List: ");
//         for (int num : arr) {
//             System.out.print(num + " ");
//         }
//     }
// }

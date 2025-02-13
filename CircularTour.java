import java.util.LinkedList;
import java.util.Queue;
public class CircularTour{
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        Queue<Integer> queue = new LinkedList<>();
        int total_surplus = 0;
        int current_surplus = 0;
        int start_index = 0;
        for (int i = 0; i < n; i++) {
            int balance = petrol[i] - distance[i];
            total_surplus += balance;
            current_surplus += balance;
            queue.add(i);
            // If current surplus becomes negative, remove pumps from queue
            while (current_surplus < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                current_surplus -= (petrol[removed] - distance[removed]);
                start_index = removed + 1;
            }
        }
        // If total_surplus is negative, no solution exists
        return (total_surplus >= 0) ? start_index : -1;
    }
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int start = findStartingPoint(petrol, distance);
        if (start == -1) {
            System.out.println("No circular tour is possible.");
        } else {
            System.out.println("Start the tour from petrol pump index: " + start);
        }
    }
}

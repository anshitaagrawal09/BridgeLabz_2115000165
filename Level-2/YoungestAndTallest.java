
import java.util.Scanner;
public class YoungestAndTallest {
    public static int findYoungest(int[] ages) {
        int youngestAge = ages[0];
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < youngestAge) {
                youngestAge = ages[i];
                youngestIndex = i;
            }
        }
        return youngestIndex;
    }
    public static int findTallest(double[] heights) {
        double tallestHeight = heights[0];
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
                tallestIndex = i;
            }
        }
        return tallestIndex;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the age of " + friends[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter the height of " + friends[i] + ": ");
            heights[i] = scanner.nextDouble();
        }
        int youngestIndex = findYoungest(ages);
        int tallestIndex = findTallest(heights);
        System.out.println(friends[youngestIndex] + " is the youngest among the friends.");
        System.out.println(friends[tallestIndex] + " is the tallest among the friends.");
        scanner.close();
    }
}


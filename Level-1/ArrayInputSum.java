
import java.util.Scanner;
public class ArrayInputSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        while (true) {
            double input = scanner.nextDouble();
            if (input <= 0 || index == 10) break;
            numbers[index] = input;
            index++;
        }
        for (int i = 0; i < index; i++) {
            total += numbers[i];
            System.out.println("Number " + (i + 1) + ": " + numbers[i]);
        }
        System.out.println("Total: " + total);
    }
}


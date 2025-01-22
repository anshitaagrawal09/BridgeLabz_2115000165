import java.util.Scanner;
public class AthleteRounds {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length of side1 of the triangle in meters: ");
        double side1 = input.nextDouble();
        System.out.print("Enter the length of side2 of the triangle in meters: ");
        double side2 = input.nextDouble();
        System.out.print("Enter the length of side3 of the triangle in meters: ");
        double side3 = input.nextDouble();
        // Calculate the perimeter of the triangle
        double perimeter = side1 + side2 + side3;
        // Convert 5 km to meters
        double totalDistance = 5000;
        // Calculate the number of rounds needed
        double rounds = totalDistance / perimeter;
        System.out.println("The total number of rounds the athlete will run is " + rounds + " to complete 5 km.");
        input.close();
    }
}


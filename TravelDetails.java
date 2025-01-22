import java.util.Scanner;
public class TravelDetails {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Taking user inputs for travel details
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter the starting city: ");
        String fromCity = input.nextLine();
        System.out.print("Enter the via city: ");
        String viaCity = input.nextLine();
        System.out.print("Enter the final destination city: ");
        String toCity = input.nextLine();
        // Taking user inputs for distances in miles
        System.out.print("Enter the distance from " + fromCity + " to " + viaCity + " in miles: ");
        double fromToVia = input.nextDouble();
        System.out.print("Enter the distance from " + viaCity + " to " + toCity + " in miles: ");
        double viaToFinalCity = input.nextDouble();
        // Taking user input for time taken in hours
        System.out.print("Enter the time taken in hours: ");
        double timeTaken = input.nextDouble();
        // Calculate the total distance
        double totalDistance = fromToVia + viaToFinalCity;
        // Calculate the average speed
        double averageSpeed = totalDistance / timeTaken;
        // Display the results
        System.out.println("\nTravel details for " + name + ":");
        System.out.println("Starting city: " + fromCity);
        System.out.println("Via city: " + viaCity);
        System.out.println("Final destination city: " + toCity);
        System.out.println("Total distance traveled: " + totalDistance + " miles");
        System.out.println("Average speed: " + averageSpeed + " miles per hour");
        input.close();
    }
}


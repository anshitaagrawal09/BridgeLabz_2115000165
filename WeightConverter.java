import java.util.Scanner;
public class WeightConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the weight in pounds: ");
        double weightInPounds = input.nextDouble();
        // Convert pounds to kilograms
        double weightInKg = weightInPounds * 2.2;
        // Display the result
        System.out.println("The weight of the person in pounds is " + weightInPounds + " and in kg is " + weightInKg);
        input.close();
    }
}


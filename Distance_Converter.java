import java.util.Scanner;
public class Distance_Converter {
    public static void main(String[] args) {
        double km;
        double conversionFactor = 1.6;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the distance in kilometers: ");
        km = input.nextDouble();
        double miles = km / conversionFactor;
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        input.close();
    }
}


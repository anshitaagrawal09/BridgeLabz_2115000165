
import java.util.*;
// Abstract Class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    public double getRentalRate() {
        return rentalRate;
    }
    // Abstract method for rental cost calculation
    public abstract double calculateRentalCost(int days);
    public void displayDetails(int days) {
        System.out.println(type + " | Number: " + vehicleNumber + " | Rental Cost: $" + calculateRentalCost(days));
        if (this instanceof Insurable) {
            System.out.println(((Insurable) this).getInsuranceDetails() + " | Insurance Cost: $" + ((Insurable) this).calculateInsurance());
        }
        System.out.println("--------------------------------");
    }
}
// Interface for Insurable Vehicles
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}
// Car (Insurable)
class Car extends Vehicle implements Insurable {
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of rental rate
    }
    public String getInsuranceDetails() {
        return "Car Insurance Applied";
    }
}
// Bike (Non-Insurable)
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
}
// Truck (Insurable)
class Truck extends Vehicle implements Insurable {
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; // 20% extra charge for trucks
    }
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rental rate
    }
    public String getInsuranceDetails() {
        return "Truck Insurance Applied";
    }
}
// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("C123", 50));
        vehicles.add(new Bike("B456", 20));
        vehicles.add(new Truck("T789", 100));
        int rentalDays = 5;
        for (Vehicle v : vehicles) {
            v.displayDetails(rentalDays);
        }
    }
}


// Abstract Class: Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    // Constructor
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    // Abstract Method: To be implemented by subclasses
    public abstract double calculateFare(double distance);
    // Concrete Method: Get vehicle details
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm;
    }
    // Getter for ratePerKm (Encapsulation)
    public double getRatePerKm() {
        return ratePerKm;
    }
}
// Interface: GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
// Concrete Class: Car
class Car extends Vehicle implements GPS {
    private String location;
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
    @Override
    public String getCurrentLocation() {
        return location;
    }
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
// Concrete Class: Bike
class Bike extends Vehicle implements GPS {
    private String location;
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
    @Override
    public String getCurrentLocation() {
        return location;
    }
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
// Concrete Class: Auto
class Auto extends Vehicle implements GPS {
    private String location;
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }
    @Override
    public String getCurrentLocation() {
        return location;
    }
    @Override
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
// Ride Service: Uses Polymorphism to calculate fares
class RideService {
    public static void bookRide(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Total Fare for " + distance + " km: $" + vehicle.calculateFare(distance));
        System.out.println("---------------------------------");
    }
}
// Main Class: Demonstration
public class RideHailingApp {
    public static void main(String[] args) {
        // Creating Vehicles
        Vehicle car = new Car("C101", "John Doe", 10);
        Vehicle bike = new Bike("B202", "Alice Smith", 5);
        Vehicle auto = new Auto("A303", "Bob Johnson", 7);
        // Booking Rides (Polymorphism)
        RideService.bookRide(car, 15);  // Car ride for 15 km
        RideService.bookRide(bike, 10); // Bike ride for 10 km
        RideService.bookRide(auto, 8);  // Auto ride for 8 km
    }
}

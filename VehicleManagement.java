// Superclass Vehicle
class Vehicle {
    String model;
    int maxSpeed;
    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
// Interface Refuelable
interface Refuelable {
    void refuel(); // Abstract method to be implemented by PetrolVehicle
}
// Subclass ElectricVehicle (inherits from Vehicle)
class ElectricVehicle extends Vehicle {
    int batteryCapacity; // Battery capacity in kWh

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }
    void charge() {
        System.out.println("Charging the electric vehicle...");
    }
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}
// Subclass PetrolVehicle (inherits from Vehicle and implements Refuelable)
class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelCapacity; // Fuel capacity in liters
    PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }
    @Override
    public void refuel() {
        System.out.println("Refueling the petrol vehicle...");
    }
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}
// Main class to test the system
public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 200, 75);
        PetrolVehicle ford = new PetrolVehicle("Ford Mustang", 250, 50);

        System.out.println("Electric Vehicle Details:");
        tesla.displayInfo();
        tesla.charge();
        System.out.println();

        System.out.println("Petrol Vehicle Details:");
        ford.displayInfo();
        ford.refuel();
    }
}

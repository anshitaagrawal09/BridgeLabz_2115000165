
class Vehicle{
    private static double registrationFee = 500.0;
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    // Constructor
    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: $" + registrationFee);
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + this.ownerName);
            System.out.println("Vehicle Type: " + this.vehicleType);
            System.out.println("Registration Number: " + this.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        } else {
            System.out.println("Invalid vehicle object.");
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle("Alice", "Car", "CAR1234");
        Vehicle vehicle2 = new Vehicle("Bob", "Motorcycle", "BIKE5678");

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        // Update registration fee
        Vehicle.updateRegistrationFee(600.0);

        // Display updated details
        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}



public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;
    // Constructor to initialize rental details with a default rate
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = 50.0; // Default daily rate
    }
    // Constructor to initialize rental details with a custom rate
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }
    // Method to calculate total rental cost
    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }
    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getDailyRate() {
        return dailyRate;
    }
    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    public void setRentalDays(int rentalDays) {
        if (rentalDays > 0) {
            this.rentalDays = rentalDays;
        } else {
            System.out.println("Rental days must be positive.");
        }
    }
    public void setDailyRate(double dailyRate) {
        if (dailyRate > 0) {
            this.dailyRate = dailyRate;
        } else {
            System.out.println("Daily rate must be positive.");
        }
    }
    // Display rental details
    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: $" + dailyRate);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
    // Main method for testing
    public static void main(String[] args) {
        // Rental with default daily rate
        CarRental rental1 = new CarRental("John Doe", "Toyota Corolla", 5);
        rental1.displayRentalDetails();
        // Rental with custom daily rate
        CarRental rental2 = new CarRental("Jane Smith", "Honda Civic", 3, 60.0);
        rental2.displayRentalDetails();
        // Modify rental details using setters
        rental1.setRentalDays(7);
        rental1.setDailyRate(55.0);
        System.out.println("\nUpdated Rental Details:");
        rental1.displayRentalDetails();
    }
}


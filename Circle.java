// Class definition
class Circle {
    // Attribute
    private double radius;
    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    // Method to display details
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + calculateArea());
        System.out.println("Circumference: " + calculateCircumference());
    }
    // Main method to test the Circle class
    public static void main(String[] args) {
        // Creating a Circle object
        Circle circle1 = new Circle(5.0);
        // Displaying circle details
        circle1.displayDetails();
    }
}


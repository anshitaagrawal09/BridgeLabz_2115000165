public class Circle {
    private double radius;
    // Default constructor (sets default radius)
    public Circle() {
        this(1.0);  // Calls the parameterized constructor with default value 1.0 //chaining
    }
    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    // Method to calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }
    // Method to calculate circumference
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
    // Display method
    public void displayInfo() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }
    // Main method for testing
    public static void main(String[] args) {
        Circle defaultCircle = new Circle();  // Uses default constructor
        System.out.println("Default Circle:");
        defaultCircle.displayInfo();
        Circle customCircle = new Circle(5.0);  // Uses parameterized constructor
        System.out.println("\nCustom Circle:");
        customCircle.displayInfo();
    }
}

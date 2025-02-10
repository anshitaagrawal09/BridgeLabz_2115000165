// Abstract Class: FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    // Abstract Method: Must be implemented by subclasses
    public abstract double calculateTotalPrice();
    // Concrete Method: Get item details
    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }
    // Getters (Encapsulation: No direct modification)
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}
// Interface: Discountable
interface Discountable {
    double applyDiscount(double amount);
    String getDiscountDetails();
}
// Concrete Class: VegItem (No extra charges)
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    // Calculate total price
    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }
    // Apply discount (10% for Veg items)
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.90; // 10% discount
    }
    @Override
    public String getDiscountDetails() {
        return "Veg items get a 10% discount!";
    }
}
// Concrete Class: NonVegItem (Extra charge applied)
class NonVegItem extends FoodItem implements Discountable {
    private static final double EXTRA_CHARGE = 20.0; // Additional charge for non-veg items

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    // Calculate total price with additional charge
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + EXTRA_CHARGE;
    }
    // Apply discount (5% for Non-Veg items)
    @Override
    public double applyDiscount(double amount) {
        return amount * 0.95; // 5% discount
    }
    @Override
    public String getDiscountDetails() {
        return "Non-Veg items get a 5% discount!";
    }
}
// Order Processor: Uses Polymorphism to handle different food items
class OrderProcessor {
    public static void processOrder(FoodItem item) {
        System.out.println(item.getItemDetails());
        double totalPrice = item.calculateTotalPrice();
        System.out.println("Total Price before Discount: " + totalPrice);
        // Check if item implements Discountable
        if (item instanceof Discountable) {
            Discountable discountableItem = (Discountable) item;
            totalPrice = discountableItem.applyDiscount(totalPrice);
            System.out.println(discountableItem.getDiscountDetails());
        }
        System.out.println("Final Price after Discount: " + totalPrice);
        System.out.println("---------------------------------");
    }
}
// Main Class: Demonstration
public class OnlineFoodDelivery {
    public static void main(String[] args) {
        // Creating food items
        FoodItem vegBurger = new VegItem("Veg Burger", 100, 2);
        FoodItem chickenPizza = new NonVegItem("Chicken Pizza", 200, 1);
        // Processing Orders
        OrderProcessor.processOrder(vegBurger);
        OrderProcessor.processOrder(chickenPizza);
    }
}

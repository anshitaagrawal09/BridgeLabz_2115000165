import java.util.*;
public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();  // Stores product prices
    private LinkedHashMap<String, Double> cartOrder = new LinkedHashMap<>(); // Maintains insertion order
    private TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>(); // Sorts products by price
    // Add product to the cart
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        cartOrder.put(product, price);
        // Handling multiple products with the same price
        sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(product);
    }
    // Display products in order of addition
    public void displayCartOrder() {
        System.out.println("\nProducts in the order they were added:");
        for (Map.Entry<String, Double> entry : cartOrder.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }
    // Display products sorted by price
    public void displaySortedByPrice() {
        System.out.println("\nProducts sorted by price:");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - $" + entry.getKey());
            }
        }
    }
    // Calculate total cart price
    public double getTotalPrice() {
        double total = 0.0;
        for (double price : cartOrder.values()) {
            total += price;
        }
        return total;
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        // Adding products
        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Mouse", 25.50);
        cart.addProduct("Keyboard", 45.99);
        cart.addProduct("Monitor", 300.00);
        cart.addProduct("Mouse Pad", 25.50);
        // Display results
        cart.displayCartOrder();   // Order of addition
        cart.displaySortedByPrice(); // Sorted by price
        System.out.println("\nTotal Cart Price: $" + cart.getTotalPrice());
    }
}

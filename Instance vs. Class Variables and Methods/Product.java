
public class Product {
    private String productName;
    private double price;
    private static int totalProducts = 0; // Class variable to track total products
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment total products count
    }
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName + ", Price: $" + price);
    }
    public static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1200);
        Product p2 = new Product("Smartphone", 800);   
        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }
}


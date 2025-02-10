import java.util.ArrayList;
import java.util.List;
//Product class (Abstract)
abstract class Product{
    private int productId;
    private String name;
    private double price;

    //Constructor
    public Product(int productId,String name,double price){
        this.productId=productId;
        this.name=name;
        this.price=price;
    }

    //Getters
    public int getProductId(){
        return productId;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    //Setters
    public void setProductId(int productId){
        this.productId=productId;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public abstract double calculateDiscount();

    // Method to calculate final price (price + tax - discount)
    public double calculateFinalPrice() {
        double tax = (this instanceof Taxable) ? ((Taxable) this).calculateTax() : 0;
        return price + tax - calculateDiscount();
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Discount: " + calculateDiscount());

        if (this instanceof Taxable) {
            System.out.println(((Taxable) this).getTaxDetails());
        }

        System.out.println("Final Price: " + calculateFinalPrice());
        System.out.println("--------------------------------");
    }
}
interface Taxable{
    double calculateTax();
    String getTaxDetails();
}
// Electronics Class (Taxable)
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }
    @Override
    public double calculateTax() {
        return getPrice() * 0.15; // 15% tax
    }
    @Override
    public String getTaxDetails() {
        return "Tax (15%) applied.";
    }
}
// Clothing Class (Taxable)
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }
    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }
    @Override
    public String getTaxDetails() {
        return "Tax (5%) applied.";
    }
}
// Groceries Class (Non-Taxable)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}
// Main class to test the system
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Electronics(101, "Laptop", 1000));
        products.add(new Clothing(201, "T-Shirt", 50));
        products.add(new Groceries(301, "Apples", 30));

        for (Product product : products) {
            product.displayDetails();
        }
    }
}

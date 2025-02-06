import java.util.ArrayList;
import java.util.List;
// Product class
class Product {
    String name;
    double price;
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
// Order class (Aggregates Products)
class Order {
    Customer customer;
    List<Product> products = new ArrayList<>();
    Order(Customer customer) {
        this.customer = customer;
    }
    void addProduct(Product product) {
        products.add(product);
    }
    void showOrder() {
        System.out.println("Order for: " + customer.name);
        for (Product p : products) {
            System.out.println("- " + p.name + " ($" + p.price + ")");
        }
    }
}
// Customer class (Associated with Orders)
class Customer {
    String name;
    List<Order> orders = new ArrayList<>();
    Customer(String name) {
        this.name = name;
    }
    void placeOrder(Order order) {
        orders.add(order);
    }
    void showOrders() {
        for (Order o : orders) {
            o.showOrder();
        }
    }
}
// Main class
public class ECommerce {
    public static void main(String[] args) {
        // Create Products
        Product laptop = new Product("Laptop", 1000);
        Product phone = new Product("Phone", 500);
        // Create Customer
        Customer alice = new Customer("Alice");
        // Alice places an order
        Order order1 = new Order(alice);
        order1.addProduct(laptop);
        order1.addProduct(phone);
        alice.placeOrder(order1);
        // Show Alice's orders
        alice.showOrders();
    }
}

import java.util.ArrayList;
import java.util.List;
// Step 1: Define a category marker interface
interface ProductCategory {
    String getCategoryName();
}
// Step 2: Implement specific product categories
class BookCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Books";
    }
}
class ClothingCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Clothing";
    }
}
class GadgetCategory implements ProductCategory {
    @Override
    public String getCategoryName() {
        return "Gadgets";
    }
}
// Step 3: Create a generic Product class with a bounded type parameter
class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public T getCategory() {
        return category;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void displayInfo() {
        System.out.println("Product: " + name + " | Category: " + category.getCategoryName() + " | Price: $" + price);
    }
}
// Step 4: Generic method to apply discount
class DiscountManager {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discountAmount = product.getPrice() * (percentage / 100);
        double newPrice = product.getPrice() - discountAmount;
        product.setPrice(newPrice);
        System.out.println("Discount applied! New price of " + product.getName() + " is $" + newPrice);
    }
}
// Step 5: Product catalog to manage multiple products
class ProductCatalog {
    private List<Product<?>> products;
    public ProductCatalog() {
        this.products = new ArrayList<>();
    }
    public void addProduct(Product<?> product) {
        products.add(product);
    }
    public void displayCatalog() {
        for (Product<?> product : products) {
            product.displayInfo();
        }
    }
}
// Step 6: Main class to test the implementation
public class OnlineMarketplace {
    public static void main(String[] args) {
        // Create product categories
        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        GadgetCategory gadgetCategory = new GadgetCategory();
        // Create products
        Product<BookCategory> book = new Product<>("The Great Gatsby", 15.99, bookCategory);
        Product<ClothingCategory> tshirt = new Product<>("Graphic T-Shirt", 19.99, clothingCategory);
        Product<GadgetCategory> phone = new Product<>("Smartphone", 699.99, gadgetCategory);
        // Create a catalog and add products
        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(tshirt);
        catalog.addProduct(phone);
        // Display initial catalog
        System.out.println("=== Product Catalog Before Discount ===");
        catalog.displayCatalog();
        // Apply discount to products
        DiscountManager.applyDiscount(book, 10);  // 10% off on book
        DiscountManager.applyDiscount(tshirt, 20); // 20% off on clothing
        DiscountManager.applyDiscount(phone, 5);   // 5% off on gadget
        // Display catalog after discount
        System.out.println("\n=== Product Catalog After Discount ===");
        catalog.displayCatalog();
    }
}

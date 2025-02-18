import java.util.*;
// Step 1: Abstract WarehouseItem class
abstract class WarehouseItem {
    private String name;
    public WarehouseItem(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    // Abstract method for displaying item-specific information
    public abstract void displayInfo();
}
// Step 2: Subclasses of WarehouseItem
class Electronics extends WarehouseItem {
    private String brand;
    public Electronics(String name, String brand) {
        super(name);
        this.brand = brand;
    }
    @Override
    public void displayInfo() {
        System.out.println("Electronics - Name: " + getName() + ", Brand: " + brand);
    }
}
class Groceries extends WarehouseItem {
    private String expirationDate;
    public Groceries(String name, String expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }
    @Override
    public void displayInfo() {
        System.out.println("Groceries - Name: " + getName() + ", Expiration Date: " + expirationDate);
    }
}
class Furniture extends WarehouseItem {
    private String material;
    public Furniture(String name, String material) {
        super(name);
        this.material = material;
    }
    @Override
    public void displayInfo() {
        System.out.println("Furniture - Name: " + getName() + ", Material: " + material);
    }
}
// Step 3: Generic Storage class
class Storage<T extends WarehouseItem> {
    private List<T> items;
    public Storage() {
        items = new ArrayList<>();
    }
    public void addItem(T item) {
        items.add(item);
    }
    public List<T> getItems() {
        return items;
    }
    // Step 4: Wildcard method to display items of any type
    public void displayItems(List<? extends WarehouseItem> itemList) {
        for (WarehouseItem item : itemList) {
            item.displayInfo();
        }
    }
}
// Step 5: Main class to test the system
public class WarehouseSystem {
    public static void main(String[] args) {
        // Creating instances of different types of items
        Electronics laptop = new Electronics("Laptop", "Dell");
        Groceries apple = new Groceries("Apple", "2025-12-31");
        Furniture chair = new Furniture("Chair", "Wood");
        // Creating a storage object for warehouse items
        Storage<WarehouseItem> warehouseStorage = new Storage<>();
        // Adding items to storage
        warehouseStorage.addItem(laptop);
        warehouseStorage.addItem(apple);
        warehouseStorage.addItem(chair);
        // Displaying all items in storage using wildcard method
        warehouseStorage.displayItems(warehouseStorage.getItems());
    }
}
// ItemNode class representing an item in inventory
class ItemNode {
    int itemID;
    String itemName;
    int quantity;
    double price;
    ItemNode next;

    // Constructor
    public ItemNode(int itemID, String itemName, int quantity, double price) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
// Inventory Management Class
class InventoryManagement {
    private ItemNode head;

    // Add item at the beginning
    public void addItemAtFirst(int itemID, String itemName, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemID, itemName, quantity, price);
        newNode.next = head;
        head = newNode;
    }

    // Add item at the end
    public void addItemAtLast(int itemID, String itemName, int quantity, double price) {
        ItemNode newNode = new ItemNode(itemID, itemName, quantity, price);
        if (head == null) {
            head = newNode;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add item at a specific position
    public void addItemAtIndex(int itemID, String itemName, int quantity, double price, int position) {
        if (position == 1) {
            addItemAtFirst(itemID, itemName, quantity, price);
            return;
        }
        int count = 0;
        ItemNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (position == count + 1) { // Insert at end
            addItemAtLast(itemID, itemName, quantity, price);
            return;
        }
        // Insert at specific index
        temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }
        ItemNode newNode = new ItemNode(itemID, itemName, quantity, price);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove an item based on Item ID
    public void removeItem(int itemID) {
        if (head == null) {
            return;
        }
        if (head.itemID == itemID) {
            head = head.next;
            return;
        }
        ItemNode temp = head;
        while (temp.next != null && temp.next.itemID != itemID) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found!");
            return;
        }
        temp.next = temp.next.next;
    }

    // Update quantity of an item by Item ID
    public void updateQuantity(int itemID, int newQuantity) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found!");
    }

    // Search for an item by Item ID or Item Name
    public ItemNode searchItem(int itemID) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemID == itemID) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public ItemNode searchItem(String itemName) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Calculate total inventory value
    public double calculateTotalValue() {
        double totalValue = 0;
        ItemNode temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        return totalValue;
    }

    // Display all inventory items
    public void displayInventory() {
        ItemNode temp = head;
        while (temp != null) {
            System.out.println("Item ID: " + temp.itemID + ", Name: " + temp.itemName + ", Quantity: " + temp.quantity + ", Price: $" + temp.price);
            temp = temp.next;
        }
    }

    public void sortByName() {
    if (head == null || head.next == null) {
        return; // No need to sort if list is empty or has only one item
    }
    boolean swapped;
    do {
        swapped = false;
        ItemNode current = head;
        while (current.next != null) {
            if (current.itemName.compareToIgnoreCase(current.next.itemName) > 0) {
                // Swap item details instead of swapping nodes
                String tempName = current.itemName;
                int tempID = current.itemID;
                int tempQuantity = current.quantity;
                double tempPrice = current.price;

                current.itemName = current.next.itemName;
                current.itemID = current.next.itemID;
                current.quantity = current.next.quantity;
                current.price = current.next.price;

                current.next.itemName = tempName;
                current.next.itemID = tempID;
                current.next.quantity = tempQuantity;
                current.next.price = tempPrice;

                swapped = true; // Mark that a swap happened
            }
            current = current.next; // Move to the next node
        }
    } while (swapped); // Repeat until the list is fully sorted //it comes true if previous round have any swapped
    }

    public void sortByPrice() {
    if (head == null || head.next == null) {
        return; // No need to sort if list is empty or has only one item
    }
    boolean swapped;
    do {
        swapped = false;
        ItemNode current = head;
        while (current.next != null) {
            if (current.price > current.next.price) {
                // Swap item details instead of swapping nodes
                String tempName = current.itemName;
                int tempID = current.itemID;
                int tempQuantity = current.quantity;
                double tempPrice = current.price;

                current.itemName = current.next.itemName;
                current.itemID = current.next.itemID;
                current.quantity = current.next.quantity;
                current.price = current.next.price;

                current.next.itemName = tempName;
                current.next.itemID = tempID;
                current.next.quantity = tempQuantity;
                current.next.price = tempPrice;

                swapped = true; // Mark that a swap happened
            }
            current = current.next; // Move to the next node
        }
    } while (swapped); // Repeat until the list is fully sorted //it comes true if previous round have any swapped
    }
}
public class InventoryManagementSystem{
    public static void main(String[] args){
        InventoryManagement inventory=new InventoryManagement();
        inventory.addItemAtFirst(1,"Laptop",3,70000.0);
        inventory.addItemAtLast(2,"Mobile Phone",5,50000.0);
        inventory.addItemAtFirst(3,"Tablet",1,20000.0);
        inventory.addItemAtIndex(4, "Monitor", 7, 200.0, 2);
        inventory.displayInventory();
        System.out.println("\nSearching for Item ID 2:");
        ItemNode found = inventory.searchItem(2);
        if (found != null) {
            System.out.println("Found: " + found.itemName);
        }

        System.out.println("\nUpdating quantity of Item ID 1...");
        inventory.updateQuantity(1, 8);
        inventory.displayInventory();

        System.out.println("\nTotal Inventory Value: $" + inventory.calculateTotalValue());

        System.out.println("\nSorting inventory by Name...");
        inventory.sortByName();
        inventory.displayInventory();

        System.out.println("\nRemoving Item ID 3...");
        inventory.removeItem(3);
        inventory.displayInventory();

        System.out.println("\nSorting inventory by price...");
        inventory.sortByPrice();
        inventory.displayInventory();
    }
}

import java.util.*;
// Abstract Class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public abstract int getLoanDuration(); // Abstract method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId + " | Title: " + title + " | Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
    }
}

// Interface for Reservable Items
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Book (Reservable)
class Book extends LibraryItem implements Reservable {
    private boolean isReserved;
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }
    public int getLoanDuration() {
        return 14; // Books can be borrowed for 14 days
    }
    public void reserveItem() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Magazine (Non-Reservable)
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    public int getLoanDuration() {
        return 7; // Magazines can be borrowed for 7 days
    }
}

// DVD (Reservable)
class DVD extends LibraryItem implements Reservable {
    private boolean isReserved;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isReserved = false;
    }
    public int getLoanDuration() {
        return 5; // DVDs can be borrowed for 5 days
    }
    public void reserveItem() {
        if (!isReserved) {
            isReserved = true;
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is already reserved.");
        }
    }
    public boolean checkAvailability() {
        return !isReserved;
    }
}
// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B101", "Java Programming", "James Gosling"));
        items.add(new Magazine("M202", "National Geographic", "Various Authors"));
        items.add(new DVD("D303", "Inception", "Christopher Nolan"));
        for (LibraryItem item : items) {
            item.getItemDetails();
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem(); // Reserve if possible
            }
            System.out.println("--------------------------------");
        }
    }
}

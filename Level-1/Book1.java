
public class Book {
    private String title;
    private String author;
    private double price;
    private boolean isAvailable;
    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // Book is available by default
    }
    // Method to borrow a book
    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed: " + title);
            return true;
        } else {
            System.out.println("Sorry, " + title + " is currently not available.");
            return false;
        }
    }
    // Getters
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public double getPrice() {
        return price;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    // Setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setPrice(double price) {
        if (price > 0) {
              this.price = price;
        } else {
              System.out.println("Price must be positive.");
        }
    }
    public void setAvailability(boolean isAvailable) {
         this.isAvailable = isAvailable;
    }
    // Display book details
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }
    // Main method for testing
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        book1.displayBookInfo();
        // Borrow the book
        book1.borrowBook();
        book1.displayBookInfo();
        // Try borrowing again
        book1.borrowBook();
     }
}


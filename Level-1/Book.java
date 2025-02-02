public class Book {
    private String title;
    private String author;
    private double price;
    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }
    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // Method to display book details
    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: $" + price);
    }
    // Getters and Setters (optional)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    // Main method for testing
    public static void main(String[] args) {
        Book defaultBook = new Book();  // Using default constructor
        defaultBook.displayInfo();
        Book customBook = new Book("Atomic Habits", "James Clear",150);  // Using parameterized constructor
        customBook.displayInfo();
    }
}

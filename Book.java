// Class definition
class Book {
    // Attributes
    private String title;
    private String author;
    private double price;
    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    // Method to display book details
    public void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
    // Main method to test the Book class
    public static void main(String[] args) {
        // Creating a Book object
        Book book1 = new Book("Atomic Habits", "James Clear",149);
        // Displaying book details
        book1.displayDetails();
    }
}


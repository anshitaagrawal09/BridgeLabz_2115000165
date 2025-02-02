
class Book {
    public String ISBN;
    protected String title;
    private String author;
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}
class EBook extends Book {
    private double fileSize;
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }
    public void displayEBookDetails() {
        System.out.println("E-Book Details:");
        System.out.println("ISBN: " + ISBN); // Accessing public member
        System.out.println("Title: " + title); // Accessing protected member
        System.out.println("File Size: " + fileSize + " MB");
    }
}
public class LibrarySystem {
    public static void main(String[] args) {
        Book book1 = new Book("123-456-789", "Java Programming", "John Doe");
        EBook ebook1 = new EBook("987-654-321", "Advanced Java", "Jane Smith", 2.5);
        book1.displayBookDetails();
        ebook1.displayEBookDetails();
    }
}



import java.util.ArrayList;
import java.util.List;
// Book class (Independent Entity)
class Book {
    private String title;
    private String author;
    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public void displayBook() {
        System.out.println("Book: " + title + " by " + author);
    }
}
// Library class (Aggregates Books)
class Library {
    private String name;
    private List<Book> books;
    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();  // Aggregation: Library has books
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void displayLibraryBooks() {
        System.out.println("Library: " + name);
        for (Book book : books) {
            book.displayBook();
        }
    }
}
// Main class to demonstrate Aggregation
public class LibrarySystem {
    public static void main(String[] args) {
        // Creating independent Book objects
        Book book1 = new Book("Too good to be true", "Prajakata Kohli");
        Book book2 = new Book("Atomic Habits", "James Clear");
        Book book3 = new Book("Ikigai", "Francesc Miralles");
        // Creating Library objects
        Library library1 = new Library("City Library");
        Library library2 = new Library("University Library");
        // Adding books to different libraries
        library1.addBook(book1);
        library1.addBook(book2);
        library2.addBook(book3);
        library2.addBook(book1); // The same book can exist in multiple libraries
        // Displaying books in libraries
        library1.displayLibraryBooks();
        System.out.println();
        library2.displayLibraryBooks();
    }
}


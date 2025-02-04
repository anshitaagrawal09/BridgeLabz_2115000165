
public class Book{
    private static String libraryName="Global Library";
    private String title;
    private String author;
    private final String isbn;

    //Constructor
    public Book(String title,String author,String isbn){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
    }

    static void displayLibraryName(){
        System.out.println("Library Name: " + libraryName);
    }

    public void displayDetails() {
        if (this instanceof Book) { // Checking if 'this' is an instance of Book
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Not a valid Book instance.");
        }
    }
    public static void main(String[] args) {
        // Display library name using static method
        Book.displayLibraryName();

        // Creating book objects
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book2 = new Book("1984", "George Orwell", "9780451524935");

        // Display book details with instanceof check
        book1.displayDetails();
        book2.displayDetails();

    }
}


// Book Node Class (Doubly Linked List)
class BookNode {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    BookNode next;
    BookNode prev;
    public BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
// Library Management using Doubly Linked List
class LibraryManagement {
    private BookNode head;
    private BookNode tail;
    private int totalBooks;
    // Add a new book at the beginning
    public void addBookAtFirst(int bookId, String title, String author, String genre, boolean isAvailable) {
        BookNode newNode = new BookNode(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        totalBooks++;
    }
    // Add a new book at the end
    public void addBookAtLast(int bookId, String title, String author, String genre, boolean isAvailable) {
        BookNode newNode = new BookNode(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        totalBooks++;
    }
    // Add a new book at a specific position
    public void addBookAtIndex(int bookId, String title, String author, String genre, boolean isAvailable, int position) {
        if (position <= 1) {
            addBookAtFirst(bookId, title, author, genre, isAvailable);
            return;
        }
        BookNode newNode = new BookNode(bookId, title, author, genre, isAvailable);
        BookNode temp = head;
        int count = 1;
        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null || temp.next == null) {
            addBookAtLast(bookId, title, author, genre, isAvailable);
            return;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        totalBooks++;
    }
    // Remove a book by Book ID
    public void removeBook(int bookId) {
        if (head == null) return;
        BookNode temp = head;
        // Check if head holds the bookId
        if (temp.bookId == bookId) {
            if (head == tail) { // If only one node exists
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            totalBooks--;
            return;
        }
        // Traverse the list
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book not found!");
            return;
        }
        temp.prev.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        } else {
            tail = temp.prev; // If deleting last node
        }
        totalBooks--;
    }
    // Search for a book by Title or Author
    public void searchBook(String keyword) {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(keyword) || temp.author.equalsIgnoreCase(keyword)) {
                System.out.println("Book Found: " + temp.title + " by " + temp.author + " | Genre: " + temp.genre + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
                found = true;
            }
            temp = temp.next;
        }

        if (!found) {
            System.out.println("No books found with the keyword: " + keyword);
        }
    }
    // Update a book's Availability Status
    public void updateAvailability(int bookId, boolean isAvailable) {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                System.out.println("Updated Availability Status for Book: " + temp.title + " to " + (isAvailable ? "Available" : "Checked Out"));
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found!");
    }
    // Display all books in forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Books in Library:");
        BookNode temp = head;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + " | Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.next;
        }
    }
    // Display all books in reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Books in Reverse Order:");
        BookNode temp = tail;
        while (temp != null) {
            System.out.println("Book ID: " + temp.bookId + " | Title: " + temp.title + " | Author: " + temp.author + " | Genre: " + temp.genre + " | Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.prev;
        }
    }
    // Count total books
    public int countBooks() {
        return totalBooks;
    }
}
// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryManagement library = new LibraryManagement();
        // Adding books
        library.addBookAtFirst(101, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", true);
        library.addBookAtLast(102, "To Kill a Mockingbird", "Harper Lee", "Classic", false);
        library.addBookAtFirst(103, "1984", "George Orwell", "Dystopian", true);
        library.addBookAtIndex(104, "Moby Dick", "Herman Melville", "Adventure", true, 2);
        // Display books in forward order
        library.displayBooksForward();
        System.out.println("------------------------------------------------");
        // Display books in reverse order
        library.displayBooksReverse();
        System.out.println("------------------------------------------------");
        // Searching for a book by title
        library.searchBook("1984");
        System.out.println("------------------------------------------------");
        // Updating availability status
        library.updateAvailability(102, true);
        System.out.println("------------------------------------------------");
        // Removing a book
        library.removeBook(101);
        library.displayBooksForward();
        System.out.println("------------------------------------------------");

        // Counting total books
        System.out.println("Total Books in Library: " + library.countBooks());
    }
}

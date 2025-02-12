
// Movie Node Class (Doubly Linked List)
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
// Movie Management System using Doubly Linked List
class MovieManagementSystem {
    private MovieNode head;
    private MovieNode tail;
    // Add a movie at the beginning
    public void addMovieAtFirst(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {//means no element is present in linked list right now
            head = tail = newNode;
        } else {//some nodes are already present in linked list
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    // Add a movie at the end
    public void addMovieAtLast(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    // Add a movie at a specific position
    public void addMovieAtIndex(String title, String director, int year, double rating, int position) {
        if (position <= 1) {
            addMovieAtFirst(title, director, year, rating);
            return;
        }
       
        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null) { // If position is beyond list length, add at last
            addMovieAtLast(title, director, year, rating);
            return;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null) {
            temp.next.prev = newNode;
        } else {
            tail = newNode; // If inserted at last position
        }
        temp.next = newNode;
    }
    // Remove a movie by title
    public void removeMovie(String title) {
        if (head == null) return;
        MovieNode temp = head;
        while (temp != null && !temp.title.equalsIgnoreCase(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found!");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }
    // Search for a movie by Director or Rating
    public void searchMovie(String director, double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
                System.out.println("Movie Found: " + temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No matching movies found.");
        }
    }
    // Display movies in forward order
    public void displayMoviesForward() {
        MovieNode temp = head;
        if (temp == null) {
            System.out.println("No movies available.");
            return;
        }
        System.out.println("Movies (Forward Order):");
        while (temp != null) {
            System.out.println(temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.next;
        }
    }
    // Display movies in reverse order
    public void displayMoviesReverse() {
        MovieNode temp = tail;
        if (temp == null) {
            System.out.println("No movies available.");
            return;
        }
        System.out.println("Movies (Reverse Order):");
        while (temp != null) {
            System.out.println(temp.title + " | Director: " + temp.director + " | Year: " + temp.year + " | Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
    // Update movie rating based on title
    public void updateMovieRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found!");
    }
}
// Main Class
public class MovieManagementApp {
    public static void main(String[] args) {
        MovieManagementSystem movieList = new MovieManagementSystem();

        // Adding movies
        movieList.addMovieAtFirst("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovieAtLast("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.addMovieAtFirst("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addMovieAtIndex("Pulp Fiction", "Quentin Tarantino", 1994, 8.9, 2);

        // Display movies
        movieList.displayMoviesForward();
        System.out.println("------------------------------------------------");
        movieList.displayMoviesReverse();

        // Searching movies
        System.out.println("------------------------------------------------");
        movieList.searchMovie("Christopher Nolan", 0);  // Search by director
        movieList.searchMovie("", 8.9);                 // Search by rating

        // Updating a movie rating
        System.out.println("------------------------------------------------");
        movieList.updateMovieRating("Interstellar", 9.0);
        movieList.displayMoviesForward();

        // Removing a movie
        System.out.println("------------------------------------------------");
        movieList.removeMovie("The Godfather");
        movieList.displayMoviesForward();
    }
}


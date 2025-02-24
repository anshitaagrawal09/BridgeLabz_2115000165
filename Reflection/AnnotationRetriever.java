import java.lang.annotation.*;

// Step 1: Define the @Author annotation
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.TYPE) // Can be applied to classes only
@interface Author {
    String name();
}

// Step 2: Apply @Author annotation to a class
@Author(name = "John Doe")
class Book {
    void display() {
        System.out.println("This is a Book class.");
    }
}

// Step 3: Retrieve and display the annotation using Reflection
public class AnnotationRetriever {
    public static void main(String[] args) {
        try {
            // Get class reference
            Class<?> clazz = Book.class;

            // Check if annotation is present
            if (clazz.isAnnotationPresent(Author.class)) {
                // Retrieve the annotation
                Author author = clazz.getAnnotation(Author.class);

                // Display annotation value
                System.out.println("Author Name: " + author.name());
            } else {
                System.out.println("No Author annotation found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

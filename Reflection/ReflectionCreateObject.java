import java.lang.reflect.Constructor;

class Student {
    private String name;

    public Student() { // Default constructor
        this.name = "Unknown";
    }

    public Student(String name) { // Parameterized constructor
        this.name = name;
    }

    public void display() {
        System.out.println("Student Name: " + name);
    }
}

public class ReflectionCreateObject {
    public static void main(String[] args) {
        try {
            // Load the Student class dynamically
            Class<?> clazz = Class.forName("Student");

            // Create an instance using the default constructor
            Object obj1 = clazz.getDeclaredConstructor().newInstance();
            ((Student) obj1).display(); // Casting & calling method

            // Create an instance using the parameterized constructor
            Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
            Object obj2 = constructor.newInstance("Alice");
            ((Student) obj2).display();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

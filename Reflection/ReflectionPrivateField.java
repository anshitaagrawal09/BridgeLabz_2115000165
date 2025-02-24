import java.lang.reflect.Field;

class Person {
    private int age; // Private field

    public Person(int age) {
        this.age = age;
    }

    public void displayAge() {
        System.out.println("Age: " + age);
    }
}

public class ReflectionPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person(25); // Creating an object
            person.displayAge();

            // Accessing private field 'age' using Reflection
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true); // Allow access to private field

            // Modifying the value of 'age'
            ageField.set(person, 30);
            
            System.out.println("After modification:");
            person.displayAge(); // Now prints modified age
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

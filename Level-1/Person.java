
public class Person {
    private String name;
    private int age;
    private String address;
    // Default constructor
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    // Copy constructor that clones another person's attributes
    public Person(Person anotherPerson) {
        this.name = anotherPerson.name;
        this.age = anotherPerson.age;
        this.address = anotherPerson.address;
    }
    // Getter methods
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }
    // Setter methods
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    // Display person details
    public void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
    public static void main(String[] args) {
        // Create an original Person object
        Person person1 = new Person("John Doe", 30, "123 Main St");
        // Clone the person using the copy constructor
        Person person2 = new Person(person1);
        // Display both persons' details
        System.out.println("Original Person:");
        person1.displayPerson();
        System.out.println("\nCloned Person:");
        person2.displayPerson();
    }
}


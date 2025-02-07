// Superclass Person
class Person {
    String name;
    int id;
    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}
// Interface Worker
interface Worker {
    void performDuties(); // Abstract method to be implemented by subclasses//bydefault abstract and public in interface
}
// Subclass Chef (inherits from Person and implements Worker)
class Chef extends Person implements Worker {
    String specialty;
    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    @Override
    public void performDuties() {
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Preparing and cooking meals.");
    }
}
// Subclass Waiter (inherits from Person and implements Worker)
class Waiter extends Person implements Worker {
    int tablesAssigned;
    Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }
    @Override
    public void performDuties() {
        System.out.println("Role: Waiter");
        System.out.println("Tables Assigned: " + tablesAssigned);
        System.out.println("Duties: Serving customers and taking orders.");
    }
}
// Main class to test the system
public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("John Doe", 202, 5);
        chef.displayInfo();
        chef.performDuties();
        System.out.println();
        waiter.displayInfo();
        waiter.performDuties();
    }
}

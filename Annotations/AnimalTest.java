// Parent class Animal
class Animal {
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

// Child class Dog overriding makeSound()
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

// Main class with a different name
public class AnimalTest {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound(); // Should print "Woof! Woof!"
    }
}

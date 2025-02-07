
// Superclass Animal
class Animal{
    protected String name;
    protected int age;
    Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    public void makeSound() {
        System.out.println("This animal makes a sound.");
    }
}
//Subclass Dog
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " barks: Woof! Woof!");
    }
}
//Subclass Cat
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " meows: Meow! Meow!");
    }
}
//Subclass Bird
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " chirps: Chirp! Chirp!");
    }
}
// Main class to test polymorphism
public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy",3);
        Animal cat = new Cat("Whiskers",2);
        Animal bird = new Bird("Tweety",4);

        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}


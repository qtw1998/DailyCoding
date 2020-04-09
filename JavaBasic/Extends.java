package JavaBasic;

public class Extends {
    public static void main(String[] args) {
        Dog dog = new Dog();
        printAnimal(dog);
        printAnimal(new Animal());
    }

    public static void printAnimal(Animal animal) {
        if(animal instanceof Dog) {
            System.out.println("I'm " + animal.toString() + ".");
        } else {
            System.out.println("I'm " + animal.toString() + ".");
        }
    }
}

class Dog extends Animal{
    public String toString() {
        return "Dog";
    }
}

class Animal {
    public String toString() {
        return "Animal";
    }
}
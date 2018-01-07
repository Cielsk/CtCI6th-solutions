package stacks_and_queues.java;

import java.util.LinkedList;
import java.util.Optional;

/**
 *
 */
public class AnimalShelter {

  public static void main(String[] args) {
    Shelter shelter = new Shelter();
    shelter.enqueue(new Cat("a"));
    shelter.enqueue(new Dog("b"));
    shelter.enqueue(new Dog("c"));
    shelter.enqueue(new Cat("d"));
    shelter.enqueue(new Cat("e"));

    Animal animal = shelter.dequeueAny();
    System.out.println(animal.name);     // expect a
    System.out.println(shelter.size()); // expect 4
    System.out.println();

    Cat cat = shelter.dequeueCat();
    System.out.println(cat.name);        // expect d
    System.out.println(shelter.size()); // expect 3
    System.out.println();

    Dog dog = shelter.dequeueDog();
    System.out.println(dog.name);        // expect b
    System.out.println(shelter.size()); // expect 2
    System.out.println();

    animal = shelter.dequeueAny();
    System.out.println(animal.name);     // expect c
    System.out.println(shelter.size()); // expect 1
  }

  static class Shelter {

    private final LinkedList<Animal> buf = new LinkedList<>();

    int size() {
      return buf.size();
    }

    void enqueue(Animal animal) {
      buf.offerLast(animal);
    }

    Animal dequeueAny() {
      return buf.pollFirst();
    }

    Dog dequeueDog() {
      Optional<Animal> dogOptional = buf.stream().filter(animal -> animal instanceof Dog)
          .findFirst();
      if (dogOptional.isPresent()) {
        Animal dog = dogOptional.get();
        buf.removeFirstOccurrence(dog);
        return (Dog) dog;
      }

      return null;
    }

    Cat dequeueCat() {
      Optional<Animal> catOptional = buf.stream().filter(animal -> animal instanceof Cat)
          .findFirst();
      if (catOptional.isPresent()) {
        Animal cat = catOptional.get();
        buf.removeFirstOccurrence(cat);
        return (Cat) cat;
      }

      return null;
    }
  }

  abstract static class Animal {

    final String name;

    Animal(String name) {
      this.name = name;
    }
  }

  static class Dog extends Animal {

    Dog(String name) {
      super(name);
    }
  }

  static class Cat extends Animal {

    Cat(String name) {
      super(name);
    }
  }
}

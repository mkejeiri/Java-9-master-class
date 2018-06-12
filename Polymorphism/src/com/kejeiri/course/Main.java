package com.kejeiri.course;

public class Main {

    /*
    * Polymorphism :
    *   - overload (inside a class we have the same method with different signature)
    *   - overrides (between parent and derived class)
    * */
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();
        myDog.makeSound("another Wooff");
        myDog.makeSound("Wooff", "very loud");
        myDog.move();

        System.out.println("\n\n\n");
        Vet vet = new Vet();
        vet.giveShot(myDog);

        Cat myCat = new Cat();
        vet.giveShot(myCat);

    }
}

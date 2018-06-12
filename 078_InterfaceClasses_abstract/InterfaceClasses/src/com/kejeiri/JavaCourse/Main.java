package com.kejeiri.JavaCourse;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.setName("Linda");
        dog.setFood("Dog food");
        dog.setNumLegs(4);;
        dog.beFriendly();
        dog.play();

        AssistantDog militaryDog = new AssistantDog();
        militaryDog.setName("Rex");
        militaryDog.setFood("Dog food");
        militaryDog.setNumLegs(4);;
        militaryDog.beFriendly();
        militaryDog.play();
        militaryDog.helpIinjured();


        Wolf wolf = new Wolf();
        wolf.setFood("Prey Meat");
        wolf.setName("Wolfy");
        wolf.setNumLegs(4);
        wolf.hunt();
        wolf.killPrey();


    }
}

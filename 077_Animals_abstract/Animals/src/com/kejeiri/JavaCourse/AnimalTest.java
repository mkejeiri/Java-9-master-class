package com.kejeiri.JavaCourse;

public class AnimalTest {

    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setColor("Black");

        Lion lion = new Lion();

        lion.setName("Simba");
        lion.setFood("Meat");
        lion.setNumLegs(4);


        cat.setName("Moz");
        cat.setFood("Cat food");
        cat.setNumLegs(4);

        cat.showCat();



    }
}

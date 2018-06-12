package com.kejeiri.JavaCourses;
public class Dog extends Canine implements Pet {
    @Override
    public void beFriendly() {
        System.out.println("Friendly dog");
    }

    @Override
    public void play() {
        System.out.println("Playful dog");
    }
}

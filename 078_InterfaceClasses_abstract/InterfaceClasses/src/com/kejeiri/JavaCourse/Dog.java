package com.kejeiri.JavaCourse;

public class Dog extends Canine implements Pet{
    @Override
    public void beFriendly() {
        System.out.println(this.getName()+" Friendly dog...");

    }

    @Override
    public void play() {
        System.out.println(this.getName()+" is a Playful dog...");
    }
}

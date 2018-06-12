package com.kejeiri.JavaCourse;

public class Wolf extends Canine implements Wild{

    @Override
    public void hunt() {
        System.out.println(this.getName()+" is hunting deers...");
    }

    @Override
    public void killPrey() {
        System.out.println(this.getName()+" is killing the prey...");

    }
}

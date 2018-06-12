package com.kejeiri.JavaCourses;

public class Ball {

    //overloading : contructor
    public Ball() {}
    public Ball(String color, String name, int bouceRate, int capacity) {
        this.color = color;
        this.name = name;
        this.bounceRate = bouceRate;
        //we implement also protection
        this.setCapacity(capacity);
    }

    //Properties or instance variables
    private String color;

    //we no confusion we avoid this keyword.
    public Ball(String mColor, String mName, int mBouceRate) {
        color = mColor;
        name = mName;
        bounceRate = mBouceRate;
    }

    private String name;
    private int bounceRate;
    //think about capacity = 0; protection!!!
    private int capacity;


    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getBounceRate() {
        return bounceRate;
    }



    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBouceRate(int bouceRate) {
        this.bounceRate = bouceRate;
    }
    //Behaviours
    public void bounce(){System.out.println("Bouncing..");}
    public void deflate(){System.out.println("Deflating...");}
    public void inflate(){System.out.println("Inflating...");}

    public int getCapacity() {
        return capacity;
    }

    //Protection: A ball has a capacity
    public void setCapacity(int capacity) {
        if (capacity <=0) {
            this.capacity =1;
        }else{
            this.capacity = capacity;
        }
    }
}

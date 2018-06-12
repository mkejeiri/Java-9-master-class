package com.kejeiri.JavaCourse;

//not concrete class hence not instantiable!!!
public abstract class Animal {
    private String name;
    private int numLegs;
    private String food;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumLegs() {
        return numLegs;
    }

    public void setNumLegs(int numLegs) {
        this.numLegs = numLegs;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    //Behaviours
    public abstract void makeNoise();
    public void eat(){
        System.out.println("Eating");
    }
    public void sleep() {System.out.println("Sleeping !!!");}
}

package com.kejeiri.JavaCourse;

public class AssistantDog extends Dog implements TrainedPet {
    @Override
    public void helpIinjured() {
        System.out.println(this.getName()+" is helping injured people...");
    }

    /*
    * Those are overridden methods, they are not required
    * to be implemented since they are already implemented
     * inside the parent class "Dog"
    * */


    @Override
    public void beFriendly() {
        System.out.println(this.getName()+" is very friendly dog...");
    }

    @Override
    public void play() {
        System.out.println(this.getName()+" is very Playful dog...");
    }
}

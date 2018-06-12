package com.kejeiri.course;

public class Animal {
    private String name;


    //Method overloading
    public void makeSound(){System.out.println("grrrr");}
    public void makeSound(String soundType){System.out.println(soundType);}
    public void makeSound(String soundType, String loundness){System.out.println(soundType +" "+ loundness);}

}

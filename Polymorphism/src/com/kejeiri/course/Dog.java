package com.kejeiri.course;

public class Dog extends Animal{
 private String name;

 public void move(){
     System.out.println("Move!");
 }

 //Those overloaded methods override the parent class methods.
 public void makeSound(){System.out.println("Woof");}
 public void makeSound(String soundType){System.out.println(soundType);}
 public void makeSound(String soundType, String loundness){System.out.println(soundType +" "+ loundness);}

}

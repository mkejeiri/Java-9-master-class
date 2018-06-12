package com.kejeiri.JavaCourses;


/*
 * Interface provides common functionalities to unrelated classes/objects.
 * A kind of multi inheritance.
 * */
public class InterfaceTest {

    public static void main(String[] args) {
		Dog myDog = new Dog();
	    myDog.setName("Booby");
	    myDog.setFood("Meat");
	    myDog.setNumlegs(4);

	    System.out.println(myDog.getName());
	    myDog.beFriendly();
	    myDog.play();

    }
}

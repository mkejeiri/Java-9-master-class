package com.kejeiri.JavaCourses;

public class Basketall extends Ball {
    //this allow the compiler to check if this exist in the super/base class
    //otherwise if any typo error, an err will be shown!
    //Error:(7, 5) java: method does not override or implement a method from a supertype
    @Override
    public void bounce() {
        /*
        * Warning:(8, 17) java: bounce() in com.kejeiri.JavaCourses.Ball has been deprecated
        * */
        //super.bounce();
        System.out.println("Basketball is bouncing");
    }
    @Override
    public void deflate(){
        System.out.println("Basketball's de flating");
    }

}

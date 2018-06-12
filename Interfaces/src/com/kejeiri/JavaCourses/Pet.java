package com.kejeiri.JavaCourses;

/*
* Interface provides common functionalities to unrelated classes/objects.
* A kind of multi inheritance.
* */
public interface Pet {
    /*
    * abstract: has no body which need to be implemented at class level.
    * */
    abstract void beFriendly();
    abstract void play();
}

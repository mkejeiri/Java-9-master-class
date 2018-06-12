package com.kejeiri.JavaCourses;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //primitive types
        //int, boolean, float, double, ...

        //primitive wrapping type
        //Integer, Character, Long, Float, Double, Boolean, String, Byte

        //Autoboxing happens automatically
        ArrayList<Integer> myArray = new ArrayList<Integer>();

        int i = 13;
        myArray.add(i);

        int res = myArray.get(0);
        System.out.println(res);

        //Wrapping physically a primitive int variable
        int b = 25;
        Integer intWrapper = new Integer(b);

        //unwrapping of an int
        b = intWrapper.intValue();
        char c = 'f';

        //Wrapping a character
        Character charWrapper = new Character(c);

        //unwrapping a char
        c = charWrapper.charValue();
        System.out.println(c);
    }
}

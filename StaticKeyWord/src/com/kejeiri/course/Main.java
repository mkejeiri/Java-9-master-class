package com.kejeiri.course;

public class Main {

    private  static String name ="";
    public static void main(String[] args) {
	    // static talk only to static: non-static variable name cannot be referenced from a static context
        // use a static method if you don't need to instantiate a class!!! otherwise a memory waste!!!
        //we cannot call setName because is not static.

        name = "kejeiri";
        System.out.println(name);
    }
    public void setName(String){name=n;}
}

package com.kejeiri.JavaCourses;

public class Main {

    //Const = public static final
    public static final int JERRY= 1;
    public static final int BOBBY= 2;
    public static final int LARRY= 3;

    //Enum represent mutliple constant values, to avoid comparing to inexisting value.
    public enum Members {JERRY, BOBBY, LARRY}
    public static Members selectedPerson;


    public static void main(String[] args) {

        selectedPerson = Members.BOBBY;
        if (selectedPerson.equals(Members.BOBBY)){
            System.out.println("Bobby");
        }
        if (selectedPerson.equals(Members.LARRY)){
            System.out.println("LARRY");
        }
        if (selectedPerson.equals(Members.JERRY)){
            System.out.println("JERRY");
        }


    }
}

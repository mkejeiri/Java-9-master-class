package com.kejeiri.course;

public class Main {

    public static void main(String[] args) {
        /*StringBuilder strB = new StringBuilder();
        strB.append("hello");
        strB.append(" hello");
        System.out.println(strB);
        System.out.println(strB.length());*/

        Person myPerson = new Person("Kejeiri",40, 2);
        Person myScPerson = new Person("Kejeiri",40, 2);
        System.out.println("getClass: "+myPerson.getClass().getSimpleName());
        System.out.println("Hashcode: "+myPerson.hashCode());

        System.out.println("getClass: "+myScPerson.getClass().getSimpleName());
        System.out.println("Hashcode: "+myScPerson.hashCode());

        if (myScPerson.equals(myPerson)) {
            System.out.println("@myPerson: "+myPerson.toString());
            System.out.println("@myScPerson: "+myScPerson.toString());
            System.out.println("There are two equals object");
        }else {
            System.out.println("@myPerson: "+myPerson.toString());
            System.out.println("@myScPerson: "+myScPerson.toString());
            System.out.println("There are NOT two equals object");
        }




    }
}

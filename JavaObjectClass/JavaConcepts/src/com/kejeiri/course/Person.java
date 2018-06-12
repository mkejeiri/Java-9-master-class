package com.kejeiri.course;

public class Person {
    private String Name;

    //@Override
    /*public boolean equals(Object obj) {
        if (!(obj instanceof Person)){
            return false;
        }

        Person otherPerson = (Person)obj;
        return (this.Name == otherPerson.Name) && (this.Age == otherPerson.Age)
                && (this.NumberOfChildren == otherPerson.NumberOfChildren);
    }*/

    public Person(String name, int age, int numberOfChildren) {
        Name = name;
        Age = age;
        NumberOfChildren = numberOfChildren;
    }

    private int Age;
    private int NumberOfChildren;


    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public int getNumberOfChildren() {
        return NumberOfChildren;
    }


    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void setNumberOfChildren(int numberOfChildren) {
        NumberOfChildren = numberOfChildren;
    }



}

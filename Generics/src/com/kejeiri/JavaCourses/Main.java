package com.kejeiri.JavaCourses;
class Person {
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

 class Login<T> {
    private T name;
    private T password;

    public Login(T name, T password) {
        this.name = name;
        this.password = password;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getPassword() {
        return password;
    }

    public void setPassword(T password) {
        this.password = password;
    }
}

public class Main {
    public static void main(String[] args) {

        Person person = new Person();
        person.setName("KEJEIRI");
        person.setPassword("MyPass");

        System.out.println("------- Login<Person> ---");
        Login<Person> lgPerson = new Login<>(person, person);
        System.out.println(lgPerson.getName().getName());
        System.out.println(lgPerson.getName().getPassword());
        System.out.println("-------END Login<Person> ---");



        //Generic using String
        Login<String> login = new Login<String>("kejeiri@gmail.com","Mypass");
        System.out.println("username: "+ login.getName()+" password: "+login.getPassword());

        //Generic using Integer!
        //new Login<Integer> not necessary, new Login<> is enough!
        Login<Integer> lg = new Login<>(1,2);
        System.out.println("username: "+ lg.getName()+" password: "+lg.getPassword());
    }
}

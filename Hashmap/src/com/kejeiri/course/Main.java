package com.kejeiri.course;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        //HashMap a key-value pair = basically a dictionary.

        //This declaration is not a good pratice
        // we need to define key,value type of data: HashMap<K,V>
                HashMap users = new HashMap();
        users.put("Kejeiri",40);
        users.put("Souad",34);
        users.put("Adam",7);
        users.put("Samy",2);

        if (users.containsKey("Kejeiri")){
            System.out.println("User found!");
        }else {System.out.println("User not found!");}

        System.out.println("Values : "+users.values());
        System.out.println("All data : "+users.entrySet());
        System.out.println(users.get("Kejeiri"));
        System.out.println(users.get("Souad"));


        Iterator it = users.entrySet().iterator();
        while(it.hasNext()){
            //Map : another dictionary class
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey()+" " + pair.getValue());
        }

        /*
        * HashMap a key-value pair = basically a dictionary.
        * * */
        //The following declaration is a good practice/proper way to do things
        // we are able to define key-value type of data: HashMap<K,V>
        HashMap<String,Integer> newUsers = new HashMap<String,Integer>();
        newUsers.put("Kejeiri",40);
        newUsers.put("Souad",34);
        newUsers.put("Adam",7);
        newUsers.put("Samy",2);

        System.out.println("\n\n----------Iterator and property typed key-value pair data ------------");
        Iterator itTyped = newUsers.entrySet().iterator();
        while(itTyped.hasNext()){
            //Map : another dictionary class
            Map.Entry<String,Integer> pair = (Map.Entry<String,Integer>)itTyped.next();
            System.out.println(pair.getKey()+" " + pair.getValue());
        }
    }
}

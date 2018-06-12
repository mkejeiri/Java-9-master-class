package com.kejeiri.course;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	//ArrayList

        System.out.println("\n\n-------- ArrayList Ops! --------");
        ArrayList animals = new ArrayList();
        animals.add(34);
        animals.add("Cow");
        animals.add("Parrot");
        animals.add("Parrot1");
        animals.add("Cat");
        animals.add("ToBeRemoved");

        animals.remove(0);
        animals.add(0, "Dog");
        animals.remove("Parrot1");

        if(animals.contains("ToBeRemoved")){
            animals.remove("ToBeRemoved");
        } else {
            System.out.println("Nope");
        }


        System.out.println("animals.size(): " + animals.size());

        for (int i = 0; i <animals.size() ; i++) {
            System.out.println(animals.get(i));
        }

        System.out.println("-------- Clever loop --------");

        //Clever loop
        for (Object animal: animals) {
            System.out.println(animal);

        }

        System.out.println("\n\n-------- Simple array Ops! --------");
        int[] intArray = {1,2,3,4,5,6,7,8,9};
        String[] strArray= {"item1","item2","item3","item4"};

        for (int i = 0; i < strArray.length; i++) {
            System.out.println(strArray[i]);
        }
        System.out.print("\nPrinting intArray... ");
        for (int intEl: intArray) {
            System.out.print(intEl+" ");
        }

        System.out.print("\nPrinting stringArray... ");
        for (String str: strArray) {
            System.out.print(str +" ");
        }


        //Another array declaration
        int[] newIntArray = new int[4];
        String[] newStrArray = new String[4];

        newIntArray[0]=4;newIntArray[1]=3;newIntArray[2]=2;newIntArray[3]=1;
        System.out.print("\nPrinting newIntArray... ");
        for (int num: newIntArray) {
            System.out.print(num +" ");
        }
        newStrArray[0]="Cat";newStrArray[1]="Dog";newStrArray[2]="Donkey";newStrArray[3]="Cow";
        System.out.print("\nPrinting newStrArray... ");
        for (String str: newStrArray) {
            System.out.print(str +" ");
        }


        System.out.print("\nPrinting Sorted newStrArray... ");
        Arrays.sort(newStrArray);
        for (String str: newStrArray) {
            System.out.print(str +" ");
        }


        System.out.print("\nPrinting Sorted newIntArray... ");
        Arrays.sort(newIntArray);
        for (int num: newIntArray) {
            System.out.print(num +" ");
        }

        System.out.print("\nPrinting arrBools... ");
        boolean[] arrBools = {true,false,false,true,true,false};
        for (boolean bool: arrBools) {
            System.out.print(bool +" ");
        }

    }





 }


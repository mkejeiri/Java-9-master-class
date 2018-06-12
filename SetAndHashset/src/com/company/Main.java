package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {


        /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         * Set is an abstract type that uses HashSet for instantiation,
        * it contains unique element including null value.
        * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        //we could ignore autoboxing and use : Set<Object> set = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int[] ints = {3,5,9,26,4,78,9,22,74,74,74,74};

        for (int i = 0; i < ints.length ; i++) {
            set.add(ints[i]);
        }

        System.out.println("Our set is : " + set);
        System.out.println("Our set size is : " + set.size());
        set.remove(ints[0]);
        System.out.println("Our set is : " + set);
        System.out.println("Our set new size is : " + set.size());

        if (set.contains(3)) System.out.println("Yes");
        else System.out.println("Nope");

        /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         * TreeSet : F E W   W O R D S
        *   - contains unique sorted elements, when we pass duplicate
        *     from the Sort list this will be ignored.
        *   - doesn't accept null value :err : Exception in thread "main" java.lang.NullPointerException
        * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


        TreeSet<Integer> sortedSet = new TreeSet<>(set);
        sortedSet.add(3);
        sortedSet.add(3);
        sortedSet.add(3);
        sortedSet.add(12);

        System.out.println("Sorted Set: " + sortedSet);
        /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
                                I N F O
            We could also ignore the autoboxing and get the same result
            TreeSet<Object> sortedSet = new TreeSet<>(set);
            System.out.println("Sorted Set: " + sortedSet);
        *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */


        /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         * LinkedHashSet : F E W   W O R D S
         *   - Contains unique (duplicate will be ignored) unsorted elements like Hashset
         *   - Accept null values
         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

        System.out.println("\n\n\nLinkedHashSet : Operations");
        Set<Object> objectSet = new HashSet<>();
        Object[] objectArray = {3,5,9,26,4,78,9,22,74,74,74,74, null, null};

        for (int i = 0; i < objectArray.length; i++) {
            objectSet.add(objectArray[i]);
        }

        System.out.println("Our objectSet is : " + objectSet);
        System.out.println("Our objectSet size is : " + objectSet.size());
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>(objectSet);
        linkedHashSet.add(3);
        linkedHashSet.add(3);
        linkedHashSet.add(3);
        linkedHashSet.add(12);


        System.out.println("Our linkedHashSet is : " + linkedHashSet);
        System.out.println("Our linkedHashSet size is : " + linkedHashSet.size());

        /*   I N F O
        //   TreeSet DOESN'T accept null it crashes at instantiation
        TreeSet<Object> treeSet;
        treeSet= new TreeSet<>(objectSet); //NullPointerException at com.company.Main.main(Main.java:[this line])
        */


        /*
        *  Using Iterator on linkedHashSet
        *  also we could use Iterator for : Set, Hashset, Treeset...
        * */

        Iterator<Object> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.print(" "+ iterator.next());
        }

    }
}


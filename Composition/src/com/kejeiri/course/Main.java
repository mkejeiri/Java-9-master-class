package com.kejeiri.course;

public class Main {

    public static void main(String[] args) {
        Tub myTub = new Tub(13);
        System.out.println(myTub.getSize()+" "+myTub.getBubbleColor());

        Bathroom bth = new Bathroom(1);
        System.out.println(bth.getSize()+" Bathroom bubble color "+bth.getBathtub().getBubbleColor());
    }
}

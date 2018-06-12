package com.kejeiri.JavaCourses;

public class Main {

    public static void main(String[] args) {
	    Ball myBall = new Ball();
	    myBall.setColor("blue");
	    myBall.setName("Basketball");
	    myBall.setCapacity(10);
        System.out.println(myBall.getColor());
        System.out.println(myBall.getName());
        System.out.println(myBall.getCapacity());


        Ball myScBall = new Ball("blue", "justBall",10);
        System.out.println(myScBall.getColor());
        System.out.println(myScBall.getName());
        System.out.println(myScBall.getCapacity());

        BasketBall myBasketBall = new BasketBall();
        System.out.println(myBasketBall.getBounceRate());

        //use an overridden methods
        myBasketBall.bounce();
        myBasketBall.inflate();
        myBasketBall.deflate();
    }
}

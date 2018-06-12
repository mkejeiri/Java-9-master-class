package com.kejeiri.JavaCourses;

public class Ball {
    private String ballName;
    private int ballSize;

    public void setUpBall(){
        //Short hand syntax using inner/nested class.
        new OrangeBall().setUpOrangeBall();
    }

    //INNER CLASS
    class OrangeBall{
        public void setUpOrangeBall(){
            //Access to the private properties of outer class from the inner/nested class
            ballName="Inside Inner class Ball";
            ballSize=15;
            System.out.println(ballName + " ," + ballSize);
        }
    }
}

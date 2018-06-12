package com.kejeiri.JavaCourses;

public class BasketBall  extends Ball{
    private boolean isNBA;
    public boolean isNBA() {
        return isNBA;
    }
    public void setNBA(boolean NBA) {
        isNBA = NBA;
    }

    public BasketBall(){
        super ("blue","basketball",15,20);
    }
    public BasketBall(String mColor, String mName, int mBouceRate, boolean isNBA){
       super(mColor,mName,mBouceRate) ;
       this.isNBA = isNBA;
    }

    //Overridden Behaviours
    public void bounce(){System.out.println("Bouncing basketball..");}
    public void deflate(){System.out.pr intln("Deflating basketball...");}
    public void inflate(){System.out.println("Inflating basketball...");}
}

package com.kejeiri.JavaCourse;

public class LambdaExpressionWithInterface {

    public static void main(String[] args) {

        /*****************************************************************
         * Doesn't work with multiple function to override!!!!
         Err: incompatible types: com.kejeiri.JavaCourse.Drawable is not a
         functional interface multiple non-overriding abstract methods found
         in interface: com.kejeiri.JavaCourse.Drawable
        *****************************************************************/

        Drawable drawable = (artist,day)-> System.out.println("drawn by: " + artist +" on : "+ day );

        //old alternative:
        /*Drawable drawable = new Drawable() {
            @Override
            public void draw(String artist, String day) {
                System.out.println("drawn by: " + artist +" on : "+ day );
            }
        };*/

        //lambda expression alternative:
        drawable.draw("Kejeiri","Tuesday");


        Addable addable = (a,b)-> (a+b);
        System.out.println(addable.add(12,12));

        Addable addableTyped = (double a, double b)-> (a+b);
        System.out.println(addableTyped.add(12,12));
    }
}

interface Drawable {
    void draw(String artist, String day);
    //void help(String help);
}

interface Addable{
    double add(double a, double b);
}

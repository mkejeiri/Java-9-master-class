package com.kejeiri.JavaCourses;

public class Main {

    public static void main(String[] args) {
        String [] myArray = {"me","mywife","children"};
        System.out.println(myArray[2]);
        float sum= 0;
        for (String argument:args){
            try {
                sum += Float.parseFloat(argument);
            }catch (NumberFormatException ex){
                System.out.println(ex.fillInStackTrace());
                sum += -1.00f;
            }catch (Exception ex){
                //this should be left at the end, because compiler gives err if put before,NumberFormatException
                // Err: has already been caught
            }
            //Always run: think about closing the connection with a DB!!!
            finally {
                System.out.println("I'm in finally block");
            }

        }
        System.out.println("sum is " +sum);
    }
}
package com.kejeiri.JavaCourses;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        byte data[] = new byte[11];
        System.out.println("Enter characters:");
        System.in.read(data);
        System.out.println("You entered: ");
        for (int i = 0; i < data.length; i++) {
            System.out.print((char)data[i]);
        }
    }
}

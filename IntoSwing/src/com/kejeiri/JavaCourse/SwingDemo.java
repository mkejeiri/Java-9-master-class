package com.kejeiri.JavaCourse;
import javax.swing.*;
public class SwingDemo {

    public SwingDemo(){
        //Create a new JFrame container
        JFrame jFrame = new JFrame("my Swing app");

        //Give it a size, default is zero
        jFrame.setSize(270, 100);

        //Terminate the program when the user closes the app
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Jlabel

        JLabel jlabel = new JLabel("Wow this is amazing");
        jFrame.add(jlabel);

        //show the frame
        jFrame.setVisible(true);

    }

    public static void main(String[] args) {
        //run the UI in separate thread, so we don't disrupt the main thread
        //Create the frame on the event dispatching thread

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
               new SwingDemo();
            }
        });


    }
}

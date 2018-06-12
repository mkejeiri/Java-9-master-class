package com.kejeiri.JavaCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo  implements ActionListener{
    public JLabel jLabel;

    ButtonDemo(){

        JFrame jFrame = new JFrame("Button demo title");
        jFrame.setSize(200,200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setLayout(new FlowLayout());


        ///
        JButton upButton = new JButton("Up");
        JButton downButton = new JButton("Down");
        jLabel = new JLabel("Press a button");

        jFrame.add(upButton);
        jFrame.add(downButton);
        jFrame.add(jLabel);
        upButton.addActionListener(this);
        downButton.addActionListener(this);
/*
        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("upButton Clicked");
            }
        });

      downButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              System.out.println("down is clicked");
          }
      });*/



    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonDemo();
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getActionCommand().equals("Up")){jLabel.setText("You pressed Up");}
        if (e.getActionCommand().equals("Down")){jLabel.setText("You pressed Down");}
    }
}

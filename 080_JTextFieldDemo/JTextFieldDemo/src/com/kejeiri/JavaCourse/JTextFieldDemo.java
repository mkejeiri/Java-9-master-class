package com.kejeiri.JavaCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JTextFieldDemo  implements ActionListener {
    private JTextField jTextField;
    private JButton reverseButton;
    private JLabel promptLabel;
    private JLabel contentLabel;

    public JTextFieldDemo(){
        JFrame jFrame = new JFrame("JTextField Demo");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(200,200);

        //Set visible
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Create JTextField
        jTextField = new JTextField(10);
        jTextField.setActionCommand("textField");
        jTextField.addActionListener(this);


        //Create a button
        reverseButton = new JButton("reverse");
        reverseButton.addActionListener(this);


        //Create labels
        promptLabel = new JLabel("Enter Text:");
        contentLabel = new JLabel("");

        //Add all UI element to the jFrame
        jFrame.add(promptLabel);
        jFrame.add(jTextField);
        jFrame.add(reverseButton);
        jFrame.add(contentLabel);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JTextFieldDemo();
            }
        });
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("reverse")) {
            if (!jTextField.getText().equals("")){
                StringBuilder textReversed = new StringBuilder(jTextField.getText());
                contentLabel.setText(textReversed.reverse().toString());
            }
        } else {
            contentLabel.setText("You entered : " + jTextField.getText());
        }


    }
}

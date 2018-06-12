package com.kejeiri.JavaCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FlashCardBuilder {
    private JTextArea question;
    private JTextArea answer;
    private ArrayList<FlashCard> cardList;
    private JFrame frame;

    public FlashCardBuilder() {
        //Build the user interface
        frame = new JFrame("Flash card");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //Create a JPanel to hold everything
        JPanel mainPanel = new JPanel();

        //Create a font
        Font appFont = new Font("Helvetica neue",Font.BOLD, 21);
        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(appFont);

        //qScrollPane
        JScrollPane qScrollPane = new JScrollPane(question);
        qScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        qScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        answer = new JTextArea(6,20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(appFont);
        //aScrollPane
        JScrollPane aScrollPane = new JScrollPane(answer);
        aScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        aScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        JButton nextButton = new JButton("Next Card");
        nextButton.addActionListener(new NextCardActionListener());

        //Create a few labels
        JLabel qLabel = new JLabel("Question");
        JLabel aLabel = new JLabel("Answer");

        //ADD components to the mainPanel
        mainPanel.add(qLabel);
        mainPanel.add(qScrollPane);
        mainPanel.add(aLabel);
        mainPanel.add(aScrollPane);
        mainPanel.add(nextButton);

        //Create a menu
        JMenuBar jMenuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new NewMenuItemActionListener());
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener(new SaveMenuItemActionListener());

        file.add(newMenuItem);
        file.add(saveMenuItem);
        jMenuBar.add(file);
        frame.setJMenuBar(jMenuBar);


        //Add to the frame
        frame.getContentPane().add(BorderLayout.CENTER,  mainPanel);
        frame.setSize(540,600);
        frame.setVisible(true);

        cardList = new ArrayList<>();

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlashCardBuilder();
            }
        });
    }

    class NextCardActionListener  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cardList.add(new FlashCard(question.getText(), answer.getText()));
            clearCard();
            //System.out.print(" cardList size : " + cardList.size());
        }
    }

    class NewMenuItemActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("New clicked");
        }
    }

    class SaveMenuItemActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            cardList.add(new FlashCard(question.getText(),answer.getText()));

            //Create a file dialog with a file chooser
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());


        }

    }
    private void saveFile(File selectedFile) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(selectedFile));
            Iterator<FlashCard> iterator = cardList.iterator();
            while (iterator.hasNext())
            {
                FlashCard flashCard =(FlashCard)iterator.next();
                bufferedWriter.write(flashCard.getQuestion()+"/");
                bufferedWriter.write(flashCard.getAnswer()+"\n");
            }

            /*
            //Alternatively
            for(FlashCard flashCard:cardList){
                bufferedWriter.write(flashCard.getQuestion()+"/"+flashCard.getAnswer()+"\n");
            }*/

            bufferedWriter.close();

        } catch (IOException ex) {
           System.out.println("Unable to write in file " + selectedFile.getPath());
           ex.printStackTrace();
        }

    }

    public void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }
}


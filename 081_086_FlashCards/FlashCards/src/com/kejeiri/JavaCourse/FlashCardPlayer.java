package com.kejeiri.JavaCourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class FlashCardPlayer {

    private JTextArea display;
    private JTextArea answer;
    private ArrayList<FlashCard> cardList;
    private Iterator cardIterator;
    private FlashCard currentCard;
    private int currentCardIndex;
    private JButton showAnswer;
    private JFrame frame;
    private boolean isShowAnswer;

    public FlashCardPlayer() {
        //Build a UI
        frame = new JFrame("Flash Card Player");
        frame.setSize(600, 700);
        JPanel mainPanel = new JPanel();
        Font fontApp = new Font("Helvetica neue",Font.BOLD,22);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JTextArea(10,20);
        display.setFont(fontApp);

        JScrollPane qJScrollPane = new JScrollPane(display);
        qJScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        qJScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        showAnswer = new JButton("Show next answer");
        mainPanel.add(qJScrollPane);
        mainPanel.add(showAnswer);

        showAnswer.addActionListener(new NextCardListener());

        //Create a  JMenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadItemMenu = new JMenuItem("Load Card Set");
        loadItemMenu.addActionListener(new OpenMenuListener());
        fileMenu.add(loadItemMenu);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);


        //Add to frame
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FlashCardPlayer();
            }
        });

    }

    class NextCardListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isShowAnswer) {
                display.setText(currentCard.getAnswer());
                showAnswer.setText("Next Card");
                isShowAnswer = false;
            } else
            {
                ShowNextCard();
            }
        }
    }

    class OpenMenuListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Create a file dialog with a file chooser
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());
        }
    }

    private void loadFile(File selectedFile) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            String line = null;
            cardList = new ArrayList<>();
            while ((line = reader.readLine()) != null){
                makeCard(line);
            }
            reader.close();
        } catch (IOException ex) {
            System.out.println("Unable to open file " + selectedFile.getPath());
            ex.printStackTrace();
        }

        //Show first card
        cardIterator = cardList.iterator();
        ShowNextCard();
    }

    private void ShowNextCard() {
        if (cardIterator.hasNext()){
            currentCard = (FlashCard) cardIterator.next();
            display.setText(currentCard.getQuestion());
            showAnswer.setText("Show answer");
            isShowAnswer = true;
        } else  {
            display.setText("That was the last card");
            showAnswer.setEnabled(false);
        }

    }

    private void makeCard(String lineToParse) {
        StringTokenizer res = new StringTokenizer(lineToParse,"/");
        FlashCard flashCard = new FlashCard(res.nextToken(),res.nextToken());
        cardList.add(flashCard);
        //Traditional way!!!
        /*String[] result = lineToParse.split("/");
        FlashCard flashCard = new FlashCard(result[0],result[1]);
        cardList.add(flashCard);*/
    }
}

package com.kejeiri.JavaCourses;
import java.io.*;

public class WriteToFile {
    public static void main(String[] args) {
        /* * * * * * * * * * * * * * * * * * * * * * * * *
        * FileWriter & FileReader
        * * * * * * * * * * * * * * * * * * * * * * * * */

        try {
            File file = new File("MyFile.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("this is me trying to write into this file....");
            fileWriter.close();
            FileReader fileReader = new FileReader(file);

            //BufferedReader has more capabilities when it comes to read stream.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line=bufferedReader.readLine()) != null){
                    System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {}

        /* * * * * * * * * * * * * * * * * * * * * * * * *
         * FileWriter & FileReader
         * This is a low level byte reading, we are dealing
         * with bytes
         * * * * * * * * * * * * * * * * * * * * * * * * */
        try {
            File fileStream = new File("MyFile.txt");
            //we used FileInputStream because the data come in byte we need
            //to operate in byte!
            FileInputStream fileInputStream = new FileInputStream(fileStream);
            System.out.println("Total size to read  in bytes is " + fileInputStream.available());

            int content;
            while ((content=fileInputStream.read()) != -1){
                System.out.print((char) content);
            }
        } catch (IOException ex) {}
        finally {}


        /* * * * * * * * * * * * * * * * * * * * * * * * *
         * BufferedReader
         * This is a high level string reading, we are NOT
         * dealing with bytes here
         * * * * * * * * * * * * * * * * * * * * * * * * */
        System.out.println("\n-------------- BufferedReader --------------");

        try {
            File file = new File("MyFile.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while((line = bufferedReader.readLine()) !=null){
                System.out.println(line);

            }


        }catch (IOException e) {}
        finally {}


    }
}

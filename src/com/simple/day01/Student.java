package com.simple.day01;

import java.io.*;

public class Student {
    public static void main(String[] args) {
        String content[] ={"你好","大家好","同志们好"};
        File file = new File("E:\\write.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (int i = 0; i <content.length ; i++) {
                writer.write(content[i]);
                writer.newLine();
            }
            writer.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String s=null;
            int i=0;
            while ((s=bufferedReader.readLine()) != null){
                i++;
                System.out.println("第"+i+"行"+s);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package com.simple.day01;

import java.io.*;

public class FileTest {

    public static void main(String[] args) {
        File file =new File("E:\\write.txt");
        try {
            FileOutputStream outputStream =new FileOutputStream(file);
            byte buy[]="hello".getBytes();
            outputStream.write(buy);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
        FileInputStream inputStream =new FileInputStream("E:\\write.txt");
        byte byt[]=new byte[1024];
        int read = inputStream.read(byt);
        System.out.println("文件信息"+new String(byt,0,read));
        inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package com.simple.day01;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyZip {
    public static void main(String[] args) {
        MyZip myZip = new MyZip();
        try {
            myZip.zip("E:/hello.zip",new File("E:/hello"));
            System.out.println("压缩完成...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void zip(String zipFileName, File inputFile) throws IOException {
        ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(zipFileName));
        zip(outputStream,inputFile,"");
        System.out.println("压缩中...");
        outputStream.close();
    }
    private void zip(ZipOutputStream zipOutputStream,File file,String base) throws IOException {
        if (file.isDirectory()){
            File[] files = file.listFiles();
            //创建文件夹
            zipOutputStream.putNextEntry(new ZipEntry(base+"/"));
            base=base.length()==0 ?"":base+"/";
            for (int i = 0; i <files.length ; i++) {
                zip(zipOutputStream,files[i],base+files[i]);
            }
        }else {
            zipOutputStream.putNextEntry(new ZipEntry(base));
            FileInputStream inputStream =new FileInputStream(file);
            int b;
            System.out.println("base"+base);
            while ((b=inputStream.read()) !=-1){
                zipOutputStream.write(b);
            }
            inputStream.close();
        }
    }
}

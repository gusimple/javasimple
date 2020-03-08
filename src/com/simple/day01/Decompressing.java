package com.simple.day01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Decompressing {
    public static void main(String[] args) {
        try {
            ZipInputStream zipInputStream =new ZipInputStream(new FileInputStream("F:\\hello.zip"));
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            while (((nextEntry=zipInputStream.getNextEntry()) !=null) && !nextEntry.isDirectory()){
                File file =new File(nextEntry.getName());
                if (!file.exists()){
                    file.mkdirs();
                    file.createNewFile();
                }else {

                }
                zipInputStream.closeEntry();
                System.out.println("解压成功");
            }
            zipInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

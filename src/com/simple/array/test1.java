package com.simple.array;

import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Auther gusim
 * @Date 2020/6/30
 */

public class test1 {
    public static void main(String[] args) {
        String timestr = "12323";
        String[] split = timestr.split("@@");
        for (int i = 0; i <split.length ; i++) {
            System.out.println(split[i]);
        }
        //String[] str = {"1","2"};
    }
    @Test
    public void test2(){
        List<String> ys= new ArrayList<>();
        String[] s1 = {"i","o","s"};
        String[] s2 = {"i","o","a"};
        List<String> list = Arrays.asList(s1);
        List<String> list1 = Arrays.asList(s2);
        list1.stream().forEach(x->{
            if(list.contains(x)){
                ys.add(x);
            }
        });
        ys.stream().forEach(System.out::println);

    }
    @Test
    public void test3(){
        int z = 0;
        String s1 = "EA@AD@DB@BC";
        String s2 = "A@D@E@B@C";
        String replace = s2.replace("@", "");
        System.out.println("replace"+replace);
        String[] split = s1.split("@");

        List<String> list = Arrays.asList(split);
        for (int i = 0; i <list.size() ; i++) {
            if(replace.contains(list.get(i))){
               z++;
            };
        }
        System.out.println(z);

    }
    @Test
    public void test4(){
        String path ="";
        String pattern = "yyyyMMdd";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        String format = simpleDateFormat.format(new Date());
        path = path.concat(format).concat(File.separator);
        System.out.println(format);
        System.out.println(path);

    }
    @Test
    public void test5(){
        //学生答案
        String sutdentAnswer = "%%/12%%3%%%%mm%%/2%%/33";
        String s = sutdentAnswer.replaceAll("/[0-9]+", "");
        System.out.println(s);
        //正确内容存放
        List<String> correct = new ArrayList<>();
        //正确答案
        String answer = "1@2@3@2@5";
        String[] sutdentAnswers = sutdentAnswer.split("%%", 0);
        String[] answers = answer.split("@");
        System.out.println("sutdentAnswers:"+Arrays.stream(sutdentAnswers).count());
        System.out.println("answers:"+Arrays.stream(answers).count());

        Arrays.stream(answers).forEach(System.out::println);
        System.out.println("--------------------------------------");
        for (int i = 0; i <sutdentAnswers.length ; i++) {
            System.out.println(sutdentAnswers[i]+"<-----sutdentAnswers---->"+i);
        }
        for (int i = 0; i <answers.length ; i++) {
            System.out.println(answers[i]+"<------answers---->"+i);
        }
        for (int i = 0; i <sutdentAnswers.length; i++) {
            System.out.println(sutdentAnswers[i]);
            for (int j = 0; j <answers.length ; j++) {
                if (sutdentAnswers[i].equals(answers[j]) && i == j){
                    correct.add(sutdentAnswers[i]);
                }
            }
        }
        correct.stream().forEach(System.out::println);


    }

}

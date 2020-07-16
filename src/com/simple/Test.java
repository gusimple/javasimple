package com.simple;

import java.util.Date;

/**
 * @Auther gusim
 * @Date 2020/7/7
 */

public class Test {
    public static void main(String[] args) {
        Long s = 1593532481000L;
        Long s1 = 1593632481000L;
        Date date = new Date(s);
        Date date1 = new Date(s1);
        System.out.println(date);
        System.out.println(date1);
        Long clazz = 1593581190000L;
        Date date2 = new Date(clazz);
        System.out.println(date2);
    }
}

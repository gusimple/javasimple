package com.simple.jdk8;

@FunctionalInterface
public interface Myfun {

    Integer getValue(Integer num);
    //java 8 默认方法，接口和父类方法名相同，类优先
    default String getName(){
        return "111";
    }
    //java 8 接口中可以有静态方法
    public static void show(){
        System.out.println("----------");
    }
}

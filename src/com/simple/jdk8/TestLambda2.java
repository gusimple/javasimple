package com.simple.jdk8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @Auther gusim
 * @Date 2020/6/28
 */

public class TestLambda2 {
    //空参数 无返回值
    @Test
    public void test1(){
        int num = 7; //同级别 匿名内部类里面使用的局部变量 必须 final(jdk1.7 必须写)
        Runnable runnable =() -> System.out.println("hello");
        runnable.run();
    }
    //有参数 ，无返回值
    @Test
    public void test2(){
        Consumer consumer =(x)-> System.out.println(x);
        consumer.accept("11111111");
    }
    //有两个以上参数，有返回值
    @Test
    public void test3(){
        Comparator<Integer> comparator = (x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }
    //单条语句 有返回值，可以不写return
    @Test
    public void test4(){
        Comparator<Integer> comparator = (x,y)->Integer.compare(x,y);
    }
    @Test
    public void test5(){
        System.out.println(operation(100, (x) -> x * x));
    }
    public Integer operation(Integer num,Myfun myfun){
        return myfun.getValue(num);
    }
}

package com.simple.day04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 四大接口
 *  Consumer<T> :消费型接口
 *      void accept(T t);
 *  Supplier<T>:供给型接口
 *      T get();
 *  Function<T,R>:函数型接口
 *      R apply(T t)
 *  Predicate<T>:断言型接口
 *      boolean test(T t)
 */
public class TestLambda4 {
    //Predicate
    @Test
    public void test4(){
        List<String> stringList = Arrays.asList("www","gusimple","com");
        List<String> stringList1 = filterStr(stringList, x -> x.length() > 3);
        stringList1.stream().forEach(System.out::println);
    }
    //需求，将满足条件的字符串放到集合中
    public List<String> filterStr(List<String> list,Predicate<String> pre){
        List<String> list1=new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)){
                list1.add(s);
            }
        }
        return list1;
    }

    //函数型接口 Function
    @Test
    public void test3(){
        System.out.println(strHandler("sdsd dad a ", x -> x.toUpperCase()));
    }
    public String strHandler(String str,Function<String,String> function){
        return function.apply(str);
    }

    //supplier
    @Test
    public void test2(){
        List<Integer> numList = getNumList(11, () -> (int) (Math.random() * 100));
        numList.stream().forEach(System.out::println);
    }
    public List<Integer> getNumList(int num,Supplier<Integer> supplier){
        List<Integer> list =new ArrayList();
        for (int i = 0; i <num ; i++) {
            Integer n = supplier.get();
            list.add(n);
        }
        return list;
    }

   //consumer
    @Test
    public void test1(){
        happy(11.22,x-> System.out.println("消费型接口"+x));
    }
    public void happy(double money,Consumer<Double> consumer){
        consumer.accept(money);
    }
}

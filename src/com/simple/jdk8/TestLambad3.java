package com.simple.jdk8;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @Auther gusim
 * @Date 2020/6/29
 */

public class TestLambad3 {
    /**
     * comsumer<T> 消费型
     * supplier<T></> 供给型
     * fuction<T,R></> 函数型接口
     * prediate<T></> 断言型接口
     */
    @Test
    public void tes1(){
        h(100.00,m-> System.out.println("------"+m+"元"));

    }
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int) Math.random() * 100);
        numList.forEach(System.out::println);

    }
    @Test
    public void test3(){
        String s = "nihao 我 bu zhid    ";
        String str = getStr(s, y -> y.trim().toUpperCase());
        System.out.println(str);

    }
    @Test
    public void test4(){
        List<String> list = Arrays.asList("nini","sdsd","sd");
        List<String> list1 = filterStr(list, s -> s.length() > 3);
        list1.forEach(System.out::println);
    }
    public List<String> filterStr(List<String> list, Predicate<String> predicate){
        List<String> list1 = new ArrayList<>();
        list.forEach(s -> {
            if (predicate.test(s)){
                list1.add(s);
            }
        });
        return list1;
    }

    public String getStr(String str, Function<String,String> function){
        return function.apply(str);
    }
    public List<Integer> getNumList(Integer num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <num ; i++) {
            list.add(i);
        }
        return list;
    }
    public void h(double mon, Consumer<Double> consumer){
        consumer.accept(mon);
    }

}

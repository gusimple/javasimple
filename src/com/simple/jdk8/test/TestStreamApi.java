package com.simple.jdk8.test;

import com.simple.jdk8.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Auther gusim
 * @Date 2020/7/3
 */

public class TestStreamApi {
    @Test
    public void test1(){
        //collection 系列集合
        List<Integer> list = new ArrayList<>();
        list.stream();

        //数组
        Employee[] eps = new Employee[10];
        Stream<Employee> stream = Arrays.stream(eps);
        //stream 静态方法 of
        Stream<String> a = Stream.of("a", "b", "c");
        //stream 无限流
        Stream.iterate(12, x -> x + 2).limit(10).forEach(System.out::println);
        //生成
    }
    @Test
    public void test2(){
        Stream.generate(()->Math.random()).forEach(System.out::println);
    }
}

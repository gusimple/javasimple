package com.simple.day05;

import com.simple.day04.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {
    @Test
    public void test1(){
        //1.通过Collection 系列提供的 stream() 或者parallelSteam();
        List<String> list =new ArrayList<>();
        Stream<String> stream = list.stream();
        //2.通过Arrays 中静态方法stream()获取数据源
        Employee[] employees=new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(employees);
        //3.通过Stream类中的静态方法of()
        Stream<String> a = Stream.of("a", "fs", "ds");
        //4.创建无限流
        //迭代
        Stream.iterate(0, (x) -> x + 2).limit(10).forEach(System.out::println);
        //生成
        Stream.generate(()->Math.random()).limit(5).forEach(System.out::println);
    }
}

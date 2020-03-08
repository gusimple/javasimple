package com.simple.day3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {

    }
    @Test
    public void test1(){
        List<Integer> list =new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(7);
        list.add(9);
        list.forEach(s-> System.out.print(s));
        System.out.println("lists 最小值");
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        if (min.isPresent()){
            System.out.println(min.get());
        }
        System.out.println("list 最大值");
        list.stream().max(Integer::compareTo).ifPresent(System.out::println);
        System.out.println("排序");
        Stream<Integer> sorted = list.stream().sorted();
        sorted.forEach(s-> System.out.print(s));
        System.out.println("过滤");
        list.stream().filter(e->e>0)
                .filter(e->e<5)
                .sorted(Integer::compareTo)
                .forEach(System.out::print);
    }
}

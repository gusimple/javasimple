package com.simple.day3;

import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertTest {
    public static void main(String[] args) {
        List<String> collected= new ArrayList<>();
        collected.add("apjssd");
        collected.add("asfsdf");
        //collected.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
        ArrayList<String> collect = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(collect);
    }
    @Test
    public void reduceWith() throws Throwable {
        //Integer reduce = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        Integer integer[]={};
        Optional<Integer> reduce = Stream.of(integer).reduce(Integer::sum);
        reduce.orElseThrow(()->new Throwable("不能为空"));

    }
    @Test
    public void reduceTest() throws Throwable {
        Integer testInt[]={1,2,3,4};
        Optional<Integer> sumAll = Stream.of(testInt).reduce(Integer::sum);
        System.out.println(sumAll.filter(x->x>20));
        //System.out.println(sumAll.filter(x -> x>7));//Optional[10]

    }
    @Test
    public void mapTest() throws Throwable {
        String str[]={"ssfsf","dadad"};
        Optional<String> reduce = Stream.of(str).reduce(String::concat);
        System.out.println(reduce.map(x->null));
        System.out.println(reduce.map(x->x.toUpperCase()));
        //System.out.println(sumAll.filter(x -> x>7));//Optional[10]

    }
}

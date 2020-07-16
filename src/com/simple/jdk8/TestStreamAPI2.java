package com.simple.jdk8;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;
import org.w3c.dom.ls.LSException;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Auther gusim
 * @Date 2020/7/4
 */

public class TestStreamAPI2 {
    List<Employee> employees  = Arrays.asList(new Employee(22,"zs",22.22),
            new Employee(23,"ss",98.99),
            new Employee(36,"aa",98.22),
            new Employee(36,"yt",45.22),
            new Employee(78,"sdsad",98.66),
            new Employee(78,"sdsad",98.66),
            new Employee(78,"sdsad",98.66));

    /**
     * 排序
     */
    @Test
    public void test6(){

        employees.stream().sorted((e1,e2)-> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        }).forEach(System.out::println);

    }



    //flatmap 将流中每个元素转为另一个流， 然后吧所有流连城一个流
    @Test
    public void test5(){
        List<String> ls = Arrays.asList("a", "bvv", "sdad");
        ls.stream().flatMap(TestStreamAPI2::getChar).forEach(System.out::println);
    }

    public static Stream<Character> getChar(String str){
        List<Character> lsc = new ArrayList<>();
        for (Character c : str.toCharArray()){
            lsc.add(c);
        }
        return lsc.stream();
    }




    //map 接收lanbda 将元素转化成其形式或者提取信息，接收一个函数作为参数，改函数会被应用到每一个元素上，并将其映射成一个新的元素
    @Test
    public void test4(){
        List<String> ls = Arrays.asList("a", "bvv", "sdad");
        ls.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        System.out.println("-----------------------------------");
        employees.stream().map(Employee::getName).forEach(System.out::println);

    }



    //skip 跳过 与limit 互补
    //distinct（） 根据equals hashcode 去掉重复元素
    @Test
    public void test3(){
        employees.stream().filter(e->e.getAge() > 30).skip(1).distinct().forEach(System.out::println);
    }


    //limit 截断流 短路
    @Test
    public void test2(){
        employees.stream().filter(e->e.getAge() > 30).limit(2).forEach(System.out::println);
    }

    //filter 过滤 ，接收 lambda 从中排除一些元素
    //内部迭代
    @Test
    public void test1(){
        Stream<Employee> employeeStream = employees.stream().filter(x -> {
            System.out.println("api");
            return  x.getAge()>30;
        });
        employeeStream.forEach(System.out::println);

    }
}

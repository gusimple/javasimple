package com.simple.jdk8;

import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import java.util.*;

/**
 * @Auther gusim
 * @Date 2020/6/28
 */

public class TestLambda {
    //匿名内部类
    public void test1(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }
    //lambda
    public void test2(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }
    //案例 获取员工大于35岁都
    List<Employee> list = Arrays.asList(new Employee(22,"zs",22.22),
            new Employee(23,"ss",98.99),
            new Employee(15,"aa",98.22),
            new Employee(36,"yt",45.22),
            new Employee(78,"sdsad",98.66));
    @Test
    public void test3(){
        List<Employee> list1 = new ArrayList<>();
        list.stream().filter(e->e.getSalary() > 29)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------");
        list.stream().map(Employee::getName)
                .forEach(System.out::println);
    }
}

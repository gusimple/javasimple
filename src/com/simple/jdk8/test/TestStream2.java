package com.simple.jdk8.test;

import com.simple.jdk8.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Auther gusim
 * @Date 2020/7/5
 */

public class TestStream2 {
    List<Employee> employees  = Arrays.asList(new Employee(22,"zs",22.22, Employee.Status.BUSY),
            new Employee(23,"ss",98.99,Employee.Status.FREE),
            new Employee(36,"aa",98.22,Employee.Status.VOC),
            new Employee(36,"yt",45.22,Employee.Status.FREE),
            new Employee(78,"sdsad",98.66,Employee.Status.BUSY));
    // 每个数的平方
    @Test
    public void test1(){
        Integer[] integers= new Integer[]{1,2,3,4};
        Arrays.stream(integers).map(x -> x * x).forEach(System.out::println);
        System.out.println("---------------------------------------------");

    }
    //map + reduce 统计个数
    @Test
    public void test2(){
        Optional<Integer> reduce = employees.stream().map(employee -> 1).reduce(Integer::sum);
        System.out.println(reduce.get());
    }
}

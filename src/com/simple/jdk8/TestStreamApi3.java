package com.simple.jdk8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther gusim
 * @Date 2020/7/5
 */

public class TestStreamApi3 {
    List<Employee> employees  = Arrays.asList(new Employee(22,"zs",22.22, Employee.Status.BUSY),
            new Employee(23,"ss",98.99,Employee.Status.FREE),
            new Employee(36,"aa",98.22,Employee.Status.VOC),
            new Employee(36,"yt",45.22,Employee.Status.FREE),
            new Employee(78,"sdsad",98.66,Employee.Status.BUSY));

    //allMatch-检查是否匹配所有元素
    //anyMatch-任意匹配
    //noneMatch-没有匹配任意元素
    //findFirst 获取第一个元素
    //count
    //max
    //min
    @Test
    public void test1(){
        boolean b = employees.stream().allMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b);
        boolean b1 = employees.stream().anyMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);
        boolean b2 = employees.stream().noneMatch(e -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);
        Optional<Employee> first = employees.stream().sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
        System.out.println(first.get());
        Optional<Employee> any = employees.stream().filter(e -> e.getStatus().equals(Employee.Status.BUSY)).findAny();
        System.out.println(any.get());
        //count
        long count = employees.stream().count();
        System.out.println("count"+count);
        //max
        Optional<Employee> max = employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("max"+max.get());
        //min
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println("min"+min.get().getSalary());

        Optional<Double> max1 = employees.stream().map(Employee::getSalary)
                .max(Double::compare);
        System.out.println(max1.get());
    }
    //分区
    @Test
    public void test6(){
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 35));
        System.out.println(collect);
    }
    //多级分组
    @Test
    public void test5(){
        Map<Double, Map<String, List<Employee>>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getSalary, Collectors.groupingBy(e -> {
            if (e.getAge() > 35) {
                return "青年";
            } else {
                return "少年";
            }
        })));
        System.out.println(collect);
    }
    //collect 收集器 Collectors 分组
    @Test
    public void test4(){
        Map<Employee.Status, List<Employee>> collect = employees.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);

    }
    //collect 收集器 Collectors
    @Test
    public void test3(){
        List<String> collect = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println("collect:"+collect);
        HashSet<Employee> collect1 = employees.stream().collect(Collectors.toCollection(HashSet::new));
        collect1.forEach(System.out::println);
        //平均值
        Double collect2 = employees.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println("collect2:"+collect2);
        //最大值
        Optional<Employee> collect3 = employees.stream().collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println("最大值："+collect3);
        //最小值
        Optional<Double> collect4 = employees.stream().map(Employee::getSalary).collect(Collectors.minBy(Double::compare));
        System.out.println("最小值："+collect4);


    }




    //reduce  归纳
    @Test
    public void test2(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7);
        Integer reduce = list.stream().reduce(
                0, (x, y) -> x + y);
        System.out.println("reduce:"+reduce);

        Optional<Double>  op= employees.stream().map(e -> e.getSalary()).reduce(Double::sum);
        System.out.println("op.get():"+op.get());


    }

}

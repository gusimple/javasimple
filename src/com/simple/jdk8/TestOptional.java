package com.simple.jdk8;

import org.junit.Test;

import java.util.Optional;

/**
 * @Auther gusim
 * @Date 2020/7/9
 */

public class TestOptional {
    @Test
    public void test1(){
        //创建实例
        Optional<Employee> employee = Optional.of(new Employee());
        System.out.println(employee.get());
        //创建空实例
        Optional<Employee> empty = Optional.empty();
        //合并 empty 和of
        Optional<Employee> employee1 = Optional.ofNullable(new Employee());
        //判断是否空
        if (employee1.isPresent()){
            System.out.println("not null");
        }
        //or else 没有值返回 oeElse 对象
        Object emp = employee1.orElse(new Employee(12, "ss", 223.22, Employee.Status.BUSY));
        System.out.println("emp:"+emp);
        //如果调用对象包含值，返回该值，没有返回s获取的值
        Object employee2 = employee1.orElseGet(() -> new Employee());
        System.out.println(employee2);
        //map 和flatmap
        Optional<String> s1 = employee1.map(s -> s.getName());
        Optional<String> s = employee1.flatMap(e -> Optional.of(e.getName()));

    }
}

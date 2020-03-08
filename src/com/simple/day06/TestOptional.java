package com.simple.day06;

import com.simple.day04.Employee;
import org.junit.Test;

import java.util.Optional;

public class TestOptional {
    /**
     * Optional 容器里常用方法
     * Optional.of 创建一个实例
     * Optional.empty() 创建一个空的实例
     * Optional.ofNullable（T t） 若t 不为null ,创建实例。否则创建空实例
     * isPresent 判断是否包含值
     * orElse(T t)  如果调用对象包含值，就返回该值，否则返回t
     * orElseGet(Supplier s) 如果调用对象包含值，就返回该值，否则返回t
     *map(Function f) 如果有值并处理，返回处理后的Optional，否则返回Optional.empty()
     * flatMap(Function mapper) 与map类似 ，必须返回Optional
     */
    @Test
    public void test1(){
        Optional<Employee> op=Optional.of(new Employee());
        Optional<Object> op1 = Optional.ofNullable(null);
        Optional<Object> empty = Optional.empty();
        boolean present = empty.isPresent();
        //empty.orElse();
        //empty.orElseGet()
        //empty.map()
        //empty.flatMap()
        Employee employee = op.get();
        System.out.println(employee);
    }
    @Test
    public void test2(){
        Optional<Man> godnessName1 = Optional.ofNullable(new Man());
        System.out.println(godnessName1);

    }
    public String getGodnessName(Man man){
        return man.getGodness().getName();
    }
}

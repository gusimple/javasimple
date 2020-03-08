package com.simple.day04;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一 方法引用，lambda 体中的内容有方法已经实现了，就可以使用"方法引用"
 * 可以理解为 lambda 表达式得另外一种表达形式
 * 注意：1.lambda 体中调用方法的参数列表与返回值类型要与函数式接口中抽象方法的函数列表和返回值保持一致！
 *      2.若lambda 参数列表中第一个参数 是实例方法的调用者，而第二个参数是实例方法的参数时，可以使用Class::method
 * 主要有三种表达形式
 * 对象：：实例方法名
 * 类：：静态方法名
 * 类：：实例方法名
 *
 * 二 构造器引用
 * 格式
 * ClassName::new
 * 注意：需要调用的构造器参数列表要和函数式接口中抽象方法的参数列表一致！
 *
 * 三 数组引用
 * Type::new
 */
public class TestMethodRef {

    //数组引用
    @Test
    public void test6(){
        Function<Integer,String[]> function=(x)->new String[x];
        String[] apply = function.apply(10);
        System.out.println(apply.length);

        //数组引用
        Function<Integer,String[]> function1=String[]::new;
        String[] apply1 = function1.apply(2);
        System.out.println(apply1.length);
    }
    //构造器引用
    @Test
    public void test5(){
        Supplier<Employee> supplier=()->new Employee();
        supplier.get();
        //构造器引用
        Supplier<Employee> supplier1=Employee::new;

    }

    //类：：实例方法名
    @Test
    public void test4(){
        BiPredicate<String,String> bp=(x,y)->x.equals(y);
        BiPredicate<String,String> bp2=String::equals;
    }


    //对象：：实例方法名
    @Test
    public void test1(){
        Consumer<String> consumer=System.out::println;
        consumer.accept("sfsff");
    }
    @Test
    public void test2(){
        Employee employee=new Employee();
        Supplier<String> supplier=()->employee.getName();
        System.out.println(supplier.get());
        Supplier<Integer> s=employee::getAge;
    }
    //对象：：实例方法名
    @Test
    public void test3(){
        Comparator<Integer> comparator=(x,y)->Integer.compare(x,y);
        Comparator<Integer> comparator1=Integer::compare;
    }
}

package com.simple.jdk8;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Auther gusim
 * @Date 2020/6/29
 */

public class TestMethodRef {
    /**
     * 方法引用
     * 对象：：实例方法名
     * 类：：静态方法名
     * 类：：实例方法名
     * 构造器引用 className::new
     * 数组引用 tyep::new
     */
    @Test
    public void test6(){
        Function<Integer,String[]> function = (x)-> new String[x];
        Function<Integer,String[]> function1 = String[]::new;
        System.out.println(function1.apply(12));
        String[] apply = function.apply(10);
        System.out.println(apply.length);
    }

    //构造器引用 className::new  参数要与构造器相同
    @Test
    public void test5(){
        Supplier<Employee> su = ()->new Employee();
        Supplier<Employee> su1 = Employee::new;

        Function<Integer,Employee> function= Employee::new;
        Employee apply = function.apply(11);
        System.out.println(apply);


    }

    //类：：实例方法名
    //第一个参数 是调用者，第二个参数是实例中的参数
    public void test4(){
        BiPredicate<String,String> bp = String::equals;
        boolean test = bp.test("s", "ss");

    }


    //类：：静态方法名
    @Test
    public void test3(){
        Comparator<Integer> comparator = Integer::compare;
        int compare = comparator.compare(1, 2);
        System.out.println(compare);

    }



    //对象：：实例方法名
    public void test1(){
        PrintStream ps = System.out;
        Consumer<String> con = (s)->ps.println(s);

        Consumer<String> con1 = ps::println;
    }
    @Test
    public void test2(){
        Employee employee = new Employee(1,"sa",23.22);
        Employee employee1 = new Employee();
        Supplier<Integer> s = employee::getAge;
        Integer integer = s.get();
        System.out.println(integer);
    }
}

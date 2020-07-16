package com.simple.jdk8.test;

import com.simple.jdk8.Employee;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Auther gusim
 * @Date 2020/6/28
 */

public class CheckLambda {

    List<Employee> list = Arrays.asList(new Employee(22,"zs",22.22),
            new Employee(23,"ss",98.99),
            new Employee(36,"aa",98.22),
            new Employee(36,"yt",45.22),
            new Employee(78,"sdsad",98.66));
    @Test
    public void test1(){
        Collections.sort(list,(e1,e2)->{
            if (e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        list.stream().forEach(System.out::println);
    }
    @Test
    public void test2(){
        String a = getHandler("ssss sss aaa aa ", str -> str.trim());
        System.out.println(a);
    }
    @Test
    public void test3(){
        op(100L,200L,(x,y)-> x+y);
    }
    //处理字符串
    public String getHandler(String str,MyFunction myFunction){
        return myFunction.getValue(str);
    }

    public void op(Long l1,Long l2,MyFunction2<Long,Long> myFunction2){
        System.out.println(myFunction2.getValue(l1,l2));
    }
}

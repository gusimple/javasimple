package com.simple.day04;

import org.junit.Test;

import javax.jnlp.ClipboardService;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class TestLambda3 {
    List<Employee> employeeList = Arrays.asList(
            new Employee("aa",11,322.22, Employee.Status.FREE),
            new Employee("bb",13,111.11, Employee.Status.BUSY),
            new Employee("cc",13,222.22, Employee.Status.VOCATION),
            new Employee("ff",24,444.44, Employee.Status.BUSY),
            new Employee("ee",55,999.999, Employee.Status.FREE));
    @Test
    public void test1(){
        Collections.sort(employeeList,(e1,e2)->{
            if (e1.getAge()==e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else {
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    //处理字符串
    public String strHandler(String str,MyFunction myFunction){
        return myFunction.getValue(str);
    }
    @Test
    public void test2(){
        String s = strHandler("\t\t\t www  www  w w w ", str -> str.toUpperCase());
        System.out.println(s);
    }
    //对于两个long数据处理
    public void op(Long l1,Long l2,MyFunction2<Long,Long> myFunction2){
        System.out.println(myFunction2.getValue(l1,l2));
    }
    @Test
    public void test3(){
        op(11L,22L,(x,y)-> x+y);
    }
}

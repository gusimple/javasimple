package com.simple.day05;

import com.simple.day04.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ExamStream {
    List<Employee> employeeList = Arrays.asList(
            new Employee("aa",11,322.22, Employee.Status.FREE),
            new Employee("bb",13,111.11, Employee.Status.BUSY),
            new Employee("cc",13,222.22, Employee.Status.VOCATION),
            new Employee("ff",24,444.44, Employee.Status.BUSY),
            new Employee("ee",55,999.999, Employee.Status.FREE));

    /**
     * 平方操作
     */
    @Test
    public void test1(){
        Integer[] nums=new Integer[]{1,2,3,4,5};
        Arrays.stream(nums).map(x->x*x).forEach(System.out::println);
    }
    @Test
    public void test2(){
        long count = employeeList.stream().count();
        System.out.println(count);
        System.out.println(employeeList.stream().map(e -> 1).reduce(Integer::sum));
    }

}

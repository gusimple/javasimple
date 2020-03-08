package com.simple.day05;

import com.simple.day04.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 终止操作
 */
public class TestStream3 {
    List<Employee> employeeList = Arrays.asList(
            new Employee("aa",11,322.22, Employee.Status.FREE),
            new Employee("bb",13,111.11, Employee.Status.BUSY),
            new Employee("cc",13,222.22, Employee.Status.VOCATION),
            new Employee("ff",24,444.44, Employee.Status.BUSY),
            new Employee("ee",55,999.999, Employee.Status.FREE));

    /**
     * allMatch 检查是否匹配所有元素
     * anyMatch 至少匹配一个元素
     * noneMatch 检查是否没有匹配所有元素
     * findFist 返回当前流的第一个元素
     * findAny 返回当前流中的任意一个元素
     * count 返回流中的总个数
     * max 返回最大值
     * min 返回最小值
     *
     */
    @Test
    public void test1(){
        System.out.println(employeeList.stream().allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY)));
        System.out.println(employeeList.stream().anyMatch((employee -> employee.getStatus().equals(Employee.Status.BUSY))));
        System.out.println(employeeList.stream().noneMatch(employee -> employee.getStatus().equals(Employee.Status.BUSY)));
        Optional<Employee> first = employeeList.stream().sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary())).findFirst();
        System.out.println(first.get());
        Optional<Employee> any = employeeList.parallelStream().filter(employee -> employee.getStatus().equals(Employee.Status.FREE)).findAny();
        System.out.println(any.get());

    }
    @Test
    public void test2(){
        System.out.println(employeeList.stream().count());
        Optional<Employee> max = employeeList.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(max.get());
        Optional<Double> min = employeeList.stream().map(Employee::getSalary).min(Double::compareTo);
        System.out.println(min.get());
    }

    /**
     * reduce 归约
     */
    @Test
    public void test3(){
        List<Integer> list =Arrays.asList(1,2,3,4,5,6);
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        Optional<Double> reduce1 = employeeList.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println(reduce1.get());

    }
    /**
     * 收集
     * collect
     */
    @Test
    public void test4(){
        List<String> collect = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
    @Test
    public void test5(){
        System.out.println(employeeList.stream().collect(Collectors.counting()));
        System.out.println(employeeList.stream().collect(Collectors.averagingDouble(Employee::getSalary)));
    }

    /**
     * 分组
     */
    @Test
    public void test6(){
        Map<Employee.Status, List<Employee>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);
    }
    /**
     * 多级分组
     */
    @Test
    public void test7(){
        Map<Employee.Status, Map<String, List<Employee>>> collect = employeeList.stream().collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
            if (e.getAge() <= 35) {
                return "青年";
            } else {
                return "老年";
            }
        })));
        System.out.println(collect);
    }

    /**
     * 分区
     */
    @Test
    public void test8(){
        Map<Boolean, List<Employee>> collect = employeeList.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 555));
        System.out.println(collect);
    }
}

package com.simple.day05;

import com.simple.day04.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestStream2 {
    List<Employee> employeeList = Arrays.asList(
            new Employee("aa",11,322.22, Employee.Status.FREE),
            new Employee("bb",13,111.11, Employee.Status.BUSY),
            new Employee("cc",13,222.22, Employee.Status.VOCATION),
            new Employee("ff",24,444.44, Employee.Status.BUSY),
            new Employee("ee",55,999.999, Employee.Status.FREE));

    /**
     * 筛选
     * filter ,从流中排除某些元素
     * limit-截断流，使元素不超过指定数量
     * skip 跳过元素，返回一个扔掉前N个元素的流，若元素不组N个，返回一个空流，与limit 互补。
     * distinct -筛选，通过流所生成元素的hashcode()和equals()去除重复元素
     */
    @Test
    public void test1(){
        employeeList.stream().filter((e)->e.getAge()>11).distinct().forEach(System.out::println);
        //employeeList.stream().filter((e)->e.getAge()>11).skip(1).forEach(System.out::print);
    }

    /**
     * 映射
     * map-接收lambda,将元素转换成其他形式或提取信息，接收一个函数作为参数，该函数会应用到每一个元素上，将其映射成一个新的元素
     * flatmap--接收一个函数作为参数，将流中的每个值，转换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test2(){
        List<String> list=Arrays.asList("aa","bb","cc","dd");
        list.stream().map(x->x.toUpperCase()).forEach(System.out::println);
        employeeList.stream().map(Employee::getAge).forEach(System.out::println);

        //flatmap
        System.out.println("-------------------------------");
        list.stream().flatMap(TestStream2::filterCharacter).forEach(System.out::println);

    }

    /**
     * 排序
     */
    @Test
    public void test3(){
        List<String> list=Arrays.asList("aa","bb","cc","dd");
        //list.stream().sorted().forEach(System.out::println);
        employeeList.stream().sorted((e1,e2)->{
            if(e1.getAge().equals(e1.getAge())){
                return e1.getName().compareTo(e2.getName());
            }else
                return -e1.getAge().compareTo(e2.getAge());
        }).forEach(System.out::println);

    }
    public static Stream<Character> filterCharacter(String str){
        List<Character> list=new ArrayList<>();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

}

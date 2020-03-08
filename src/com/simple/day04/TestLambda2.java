package com.simple.day04;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda2 {

    //左侧 表达式 参数列表
    //右侧 表达式 所执行的功能
    //无参数 无返回值
    /*
    *语法方式一：无参数，无返回值
    * （）->system.out.printLn()
    *语法方式二：一个参数，无返回值
    * （x）->system.out.printLn() 或者 x->system.out.printLn()
    *
    * 语法方式三：有两个以上的参数，并且lambda 体中有多条语句
    *  Comparator<Integer> comparator=(x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    *
    * 语法四：若lambda只有一条语句
    * 大括号 和return 可以省略
    *
    * 语法五：
    * jvm编辑器可以通过上下文推断表达式参数列表的数据类型，参数列表的数据类型可以省略不写
    *
    * 口诀
    * 左右遇一括号省
    * 左侧推断类型省
    * 能省则省
    * */
    @Test
    public void test1(){
        //局部内部类 的局部变量 jdk1.7 必须加final jdk1.8 可以不用加，默认是存在的
        int num=0;//final
        Runnable r1=()-> System.out.println("hello"+num);
        r1.run();
    }
    @Test
    public void test2(){
        Consumer<String> consumer=(x)-> System.out.println(x);
        consumer.accept("大气");
    }
    @Test
    public void test3(){
        Comparator<Integer> comparator=(x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }
    @Test
    public void test4(){
        Comparator<Integer> comparator=(x,y)->Integer.compare(x,y);
    }
}

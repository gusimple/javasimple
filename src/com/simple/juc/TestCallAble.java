package com.simple.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther gusim
 * @Date 2020/7/10
 */
//创建线程的方式3 ：实现Callable接口，相对于runable接口方式，方法有返回值，并可以抛出异常
    //执行Callable方式，需要FutureTasks实现类的支持，用于接收运算结果，FutureTask 是Future的实现类
    //FutureTasks 具有闭锁的功能

public class TestCallAble {
    public static void main(String[] args) {
        ThreadDemo demo = new ThreadDemo();
        FutureTask<Integer> task = new FutureTask<>(demo);
        new Thread(task).start();
        //接收结果
        try {
            Integer integer = task.get();
            System.out.println(integer);
            System.out.println("-------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class ThreadDemo implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}

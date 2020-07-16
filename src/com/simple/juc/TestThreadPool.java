package com.simple.juc;

import java.util.concurrent.*;

/**
 * @Auther gusim
 * @Date 2020/7/12
 */

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //Callable 方式
        Future<Object> future = pool.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += i;
                }
                return sum;
            }
        });
        try {
            Object o = future.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();


        /*TestThread testThread =new TestThread();
        //分配任务
        for (int i = 0; i < 10; i++) {
            pool.submit(testThread);
        }

        //关闭线程池
        pool.shutdown();*/
    }

}
class TestThread implements Runnable{
    private int i = 0;

    @Override
    public void run() {
        while (i <= 100)
        System.out.println(Thread.currentThread().getName() + ":" + i++);
    }
}
package com.simple.juc;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @Auther gusim
 * @Date 2020/7/12
 */

public class TestScheduldThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 5 ; i++) {
            ScheduledFuture<Integer> result = pool.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int i = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + ":" + i);
                    return i;
                }
            }, 3, TimeUnit.SECONDS);
            System.out.println(result.get());
        }

        pool.shutdown();
    }
}

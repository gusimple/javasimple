package com.simple.jdk8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Auther gusim
 * @Date 2020/7/5
 */

public class TestForkJoin {
    @Test
    public void test1(){
        Instant start = Instant.now();
        ForkJoinPool pool =new ForkJoinPool();
        ForkJoinTask task = new ForkJoinCalculate(0,100000000L);
        System.out.println(pool.invoke(task));
        Instant end = Instant.now();
        long l = Duration.between(start, end).toMillis();
        System.out.println(l);
    }

    /**
     * 并行流
     */
    @Test
    public void test2(){
        long reduce = LongStream.rangeClosed(0, 1000000000L)
                .parallel()
                .reduce(0, Long::sum);
        System.out.println(reduce);
    }
    //
    @Test
    public void test3(){
        Instant now = Instant.now();
        LongStream.rangeClosed(0,10000000000L).parallel().reduce(0,Long::sum);
        Instant end = Instant.now();
        System.out.println("消耗时间："+Duration.between(now,end).toMillis());
    }
}

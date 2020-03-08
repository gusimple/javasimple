package com.simple.day06;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class TestForkJoin {

    @Test
    public void test1(){
        Instant start = Instant.now();
        ForkJoinPool pool=new ForkJoinPool();
        ForkJoinTask<Long> task =new ForkJoinCalculate(0,1000000000L);
        Long invoke = pool.invoke(task);
        System.out.println(invoke);
        Instant end = Instant.now();
        System.out.println(Duration.between(start,end).toMillis());
    }

}

package com.simple.juc;

import sun.misc.ClassFileTransformer;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther gusim
 * @Date 2020/7/9
 */
//CountDownLatch 闭锁，在完成某些运算，只有其他线程全部运算完成，当前运算才能继续（如，商品分类 统计后 ，求平均等）
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(5);
        CountDown countDown = new CountDown(countDownLatch);
        long l = System.currentTimeMillis();
        for (int i = 0; i <5 ; i++) {
            new Thread(countDown).start();
        }
        countDownLatch.await();
        long l1 = System.currentTimeMillis();

        System.out.println("耗费时间："+(l1-l));
    }
}
class CountDown implements Runnable{
    private CountDownLatch downLatch;

    public CountDown(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }

    @Override
    public void run() {
        synchronized (this){
            try {
                for (int i = 0; i <50000 ; i++) {
                    if (i % 2 == 0){
                        System.out.println(i);
                    }
                }
            }finally {
                downLatch.countDown();
            }
        }
    }
}

package com.simple.juc;

/**
 * @Auther gusim
 * @Date 2020/7/10
 */

import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决多线程安全的方法：
 * synchronized 隐示锁
 * 1同步代码块
 * 2同步方法
 *
 * jdk1.5以后
 * 3 同步锁lock 注意：是个显示锁
 * 需要通过lock()方法上锁，必须通过unlock释放锁
 */
public class TestLock {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"一号").start();
        new Thread(ticket,"二号").start();
        new Thread(ticket,"三号").start();
    }
}
class Ticket implements Runnable{
    private int tick = 100;
    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();//上锁
            try {
                if (tick > 0){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"余额"+ --tick);
                }
            }finally {
                lock.unlock();
            }

        }
    }
}

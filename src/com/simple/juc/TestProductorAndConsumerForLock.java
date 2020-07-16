package com.simple.juc;

/**
 * @Auther gusim
 * @Date 2020/7/11
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 等待唤醒机制  //虚假唤醒问题
 */
public class TestProductorAndConsumerForLock {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Product product = new Product(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(product,"生产A").start();
        new Thread(consumer,"消费B").start();
        new Thread(product,"生产C").start();
        new Thread(consumer,"消费D").start();
    }

}

class Clerk{
    private int product = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition =lock.newCondition();
    public void get(){
        lock.lock();
        try {
            while (product >= 1){ //为了避免虚假唤醒问题，应该总是使用在循环中
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("货满");
            }
            System.out.println(Thread.currentThread().getName()+":"+ ++product);
            condition.signalAll();

        }finally {
            lock.unlock();
        }


    }
    public void sale(){
        lock.lock();
        try {
            while (product<=0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("无货");
            }
            System.out.println(Thread.currentThread().getName()+":"+ --product);
            condition.signalAll();
        }finally {
            lock.unlock();
        }

    }
}

//消费者
class Product implements Runnable{
    private Clerk clerk;

    public Product(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            clerk.get();
        }
    }
}

class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i <20 ; i++) {
            clerk.sale();
        }
    }
}
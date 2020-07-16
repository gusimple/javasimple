/*
package com.simple.juc;

*/
/**
 * @Auther gusim
 * @Date 2020/7/11
 *//*


import java.nio.channels.NonWritableChannelException;

*/
/**
 * 等待唤醒机制  //虚假唤醒问题
 *//*

public class TestProductorAndConsumer {
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

    public synchronized void get(){
        while (product >= 1){ //为了避免虚假唤醒问题，应该总是使用在循环中
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("货满");
        }
            System.out.println(Thread.currentThread().getName()+":"+ ++product);
            this.notifyAll();

    }
    public synchronized void sale(){
        while (product<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("无货");
        }
            System.out.println(Thread.currentThread().getName()+":"+ --product);
            this.notifyAll();
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
}*/

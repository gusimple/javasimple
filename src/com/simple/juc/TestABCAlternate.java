package com.simple.juc;

/**
 * @Auther gusim
 * @Date 2020/7/11
 */


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程交替打印ABC
 */
public class TestABCAlternate {
    public static void main(String[] args) {
        AlterDemo demo =new AlterDemo();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=20 ; i++) {
                    demo.getA(i);
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=20 ; i++) {
                    demo.getB(i);
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=20 ; i++) {
                    demo.getC(i);
                }
            }
        },"C").start();
    }


}
class AlterDemo{
    private int number = 1; //表示当前线程 123 对应ABC
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void getA(Integer total){
        lock.lock();
        try {
            if (number !=1){
                try {
                    condition1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <=1 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+total);
            }
            //唤醒
            number = 2;
            condition2.signal();


        }finally {
            lock.unlock();
        }
    }
    public void getB(Integer total){
        lock.lock();
        try {
            if (number !=2){
                try {
                    condition2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <=1 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+total);
            }
            //唤醒
            number = 3;
            condition3.signal();


        }finally {
            lock.unlock();
        }
    }
    public void getC(Integer total){
        lock.lock();
        try {
            if (number !=3){
                try {
                    condition3.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 1; i <=1 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+total);
            }
            //唤醒
            number = 1;
            condition1.signal();


        }finally {
            lock.unlock();
        }
    }
}


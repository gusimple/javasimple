package com.simple.juc;

/**
 * @Auther gusim
 * @Date 2020/7/9
 */
/**
 * volatile 关键字 当多个线程共享数据的时候，可以保证内存中的数据可见 底层：内存栅栏，数据实时刷新回主内存
 * 相对于synchronized 是轻量级的同步策略
 *  volatile 不具备互斥型   synchronized 互斥的
 *  volatile 不能保证变量的原子性
 *  i++ 底层三步操作"读 改 写"
 */


import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子变量：atomic
 * 1.volatile 可见性
 * 2.cas 算法 硬件对于并发操作共享数据的支持
 * cas包含三个操作：
 * 内存值v
 * 预估值A
 * 更新值B
 * 当且仅当 V=A 是 V=B 否则不进行任何操作
 *
 */

public class  TestVolatile {

    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i <10 ; i++) {
            new Thread(atomicDemo).start();
        }
    }

}
class AtomicDemo implements Runnable{
    private AtomicInteger num = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getNum());

    }
    public int getNum(){
        return num.getAndIncrement();
    }
}

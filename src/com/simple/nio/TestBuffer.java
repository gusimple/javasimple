package com.simple.nio;

/**
 * @Auther gusim
 * @Date 2020/7/12
 */

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 1缓冲区buffer :在JAVA nio
 */
public class TestBuffer {
    @Test
    public void test1(){
        //1.分配一个指定大小的缓存区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-------------------------");

        String s="abcd";
        buffer.put(s.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-------------------------");
        //模式改为读模式
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-------------------------");
        //读取数据
        byte[] by= new byte[buffer.limit()];
        buffer.get(by);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-------------------------");
        //重复读模式
        buffer.rewind();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("-------------------------");
        //清空缓冲区，但是里面的数据没有被清空，处于"被遗忘"的状态
        buffer.clear();

    }
    @Test
    public void test2(){
        String s ="snjlaylnq";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(s.getBytes());
        buffer.flip();
        byte[] by = new byte[buffer.limit()];
        buffer.get(by,0,2);
        System.out.println(new String(by,0,2));
        System.out.println(buffer.position());
        System.out.println("-------------------------");
        buffer.mark();
        buffer.get(by,2,2);
        System.out.println(new String(by,2,2));
        System.out.println(buffer.position());
        System.out.println("-------------------------");
        //恢复到mark标记位置
        buffer.reset();
        System.out.println(buffer.position());
    }

}

package com.simple.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Auther gusim
 * @Date 2020/7/9
 */

public class TestCopyWriteArray {
    public static void main(String[] args) {
        Hello hello = new Hello();
        for (int i = 0; i <10 ; i++) {
            new Thread(hello).start();
        }
    }

}
class Hello implements Runnable{
    //CopyOnWriteArrayList 写入并复制
    private static CopyOnWriteArrayList list = new CopyOnWriteArrayList();
    static {
        list.add("aa");
        list.add("bb");
        list.add("cc");
    }

    @Override
    public void run() {
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
            list.add("yy");
        }
    }
}

package com.simple.day06;

public interface MyFun {
    /**
     * jdk1.8  1允许默认方法 2 允许有静态方法
     *
     * 方法相同  类优先
     * @return
     */
    default String getName(){
        return "0000000";
    }
}

package com.simple.jdk8.test;

@FunctionalInterface
public interface MyFunction2<R,T> {

    public R getValue(T t1,T t2);
}

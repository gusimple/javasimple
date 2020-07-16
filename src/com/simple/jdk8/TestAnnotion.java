package com.simple.jdk8;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @Auther gusim
 * @Date 2020/7/9
 */
//重复注解
public class TestAnnotion {
    @MyAnnotation("hello")
    @MyAnnotation("word")
    public void test1(){

    }
    @Test
    public void test2() throws NoSuchMethodException {
        Class<TestAnnotion> testAnnotionClass = TestAnnotion.class;
        Method test1 = testAnnotionClass.getMethod("test1");
        MyAnnotation[] annotationsByType = test1.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotationsByType) {
            System.out.println( myAnnotation.value());
        }
    }
}

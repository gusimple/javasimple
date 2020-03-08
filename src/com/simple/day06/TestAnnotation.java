package com.simple.day06;

import org.junit.Test;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Method;

/**
 * 注解与类型注解
 *
 */
public class TestAnnotation {
    @MyAnnotation("hellp")
    @MyAnnotation("world")
    public void show(@MyAnnotation("acv")String str){

    }
    @Test
    public void test1() throws NoSuchMethodException {
        Class<TestAnnotation> testAnnotationClass = TestAnnotation.class;
        Method show = testAnnotationClass.getMethod("show");
        MyAnnotation[] annotatedReturnType = show.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation myAnnotation : annotatedReturnType) {
            System.out.println(myAnnotation.value());
        }

    }
}


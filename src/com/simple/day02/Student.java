package com.simple.day02;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Student {

    private String name;

    public Student() {
        System.out.println("无参构造 创建了一个student 实例");
    }

    public Student(String str) {
        System.out.println("有参构造");
    }
    public void setName1(){
        System.out.println("调用了 setname1 方法");
    }
    public void setName2(String str){
        System.out.println("调用了 setname2 方法"+str);
    }


    public static void main(String[] args) throws Exception {
        Class studentClass =Student.class;
        Object mstudent = studentClass.newInstance();
        //获取类的属性&赋值
        Field name = studentClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(mstudent,"simple");

        //System.out.println(name.get(mstudent));
        //调用类的构造函数
        //Object o = studentClass.getConstructor().newInstance();
       // studentClass.getConstructor(String.class).newInstance("gusimple");

        //调用类对象
        Method msetName1 = studentClass.getMethod("setName1");
        msetName1.invoke(mstudent);
        Method msetName2 = studentClass.getMethod("setName2", String.class);
        msetName2.invoke(mstudent,"gusimple");

    }
}

package com.simple.jvm;

public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        System.out.println(systemClassLoader);
        //获取上层：扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);
        //获取上层：获取不到引导类加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        //用户自定义
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        //String 类使用引导类加载器加载的--》java的核心类库是使用的引导类加载器进行加载的
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);
    }
}

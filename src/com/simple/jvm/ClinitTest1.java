package com.simple.jvm;

public class ClinitTest1 {
    static class Father{
        public static int a=1;
        static {
            a=2;
        }
    }
    static class Son extends Father{
        public static int b=a;
    }

    public static void main(String[] args) {
        System.out.println(Son.b);
    }
}

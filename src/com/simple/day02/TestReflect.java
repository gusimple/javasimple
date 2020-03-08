package com.simple.day02;

public class TestReflect {
    public static void main(String[] args) {
        Product instance = Factory.getInstance("com.simple.day02.ProductB");
        instance.show();
    }
}

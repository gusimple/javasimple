package com.simple.day02;

public class Factory {
    public static Product getInstance(String className){
        Product concreteProduct = null;
        try {
            //根据传入的产品类名，获取产品类类型的class对象
            Class<?> aClass = Class.forName(className);
            concreteProduct = (Product)aClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return concreteProduct;
    }
}

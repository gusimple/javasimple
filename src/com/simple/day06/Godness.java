package com.simple.day06;

public class Godness {
    private String name;

    public Godness(String name) {
        this.name = name;
    }

    public Godness() {
    }

    @Override
    public String toString() {
        return "Godness{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

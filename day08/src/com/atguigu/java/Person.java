package com.atguigu.java;

public class Person<T extends Order> {
    String name;
    T t;

    public Person(String name, T t) {
        this.name = name;
        this.t = t;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", t=" + t +
                '}';
    }
}

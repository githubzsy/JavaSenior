package com.atguigu.java;

public class Student extends Person<Order> {

    public Student(String name, Order order) {
        super(name, order);
    }
}

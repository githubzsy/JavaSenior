package com.atguigu.java;

public class Order {
    int orderId;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                '}';
    }

    public Order(int orderId) {
        this.orderId = orderId;
    }
}

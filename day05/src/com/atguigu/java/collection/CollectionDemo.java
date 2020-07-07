package com.atguigu.java.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 一、集合框架概述
 * <p>
 * 2.1 数组特点
 * > 长度确定
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        User u = new User("alice", 3);
        coll.add(u);
        System.out.println(coll);
        /**
         * contains()与indexOf()都使用了equals()方法
         */
        System.out.println(coll.contains(u));
    }
}

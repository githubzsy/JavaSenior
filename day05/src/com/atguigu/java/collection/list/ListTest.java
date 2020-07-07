package com.atguigu.java.collection.list;

import com.atguigu.java.collection.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    @Test
    public void test1() {
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", 3));
        users.add(new User("Alice", 3));
        System.out.println(users);
    }
}

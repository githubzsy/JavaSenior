package com.atguigu.java.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CollectionsTest {
    @Test
    public void test1(){
        List list=new ArrayList();
        list.add(12);
        list.add(3);
        list.add(1);
        list.add(5);
        list.add(7);
        list.add(9);
        Collections.reverse(list);
        Collections.sort(list);
    }
}

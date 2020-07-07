package com.atguigu.java.collection.set;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetTest {
    @Test
    public void test2(){
        Set set=new LinkedHashSet();
        set.add(123);
        set.add("CCC");
        set.add("AAA");

        for (Object obj : set){
            System.out.println(obj);
        }

        /**
         * 123
         * CCC
         * AAA
         */
    }
}

package com.atguigu.java.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class MapTest {
    @Test
    public void test1(){
        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(1,"a");
        hashMap.put(2,"a");
        hashMap.put(1,"ab");
        System.out.println(hashMap.size());
    }

    @Test
    public void test2(){
        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<>();

    }
}

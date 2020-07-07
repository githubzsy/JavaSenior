package com.atguigu.java.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {

    public static void main(String[] args) {
        Goods[] arr=new Goods[3];
        arr[0]=new Goods("书本",10f);
        arr[1]=new Goods("手机",100f);
        arr[2]=new Goods("苹果",5f);


        Arrays.sort(arr, Comparator.comparing(o -> o.price));

        for (Goods goods : arr) {
            System.out.println(goods.price);
        }
    }
}

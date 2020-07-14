package com.atguigu.java;

import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式使用
 *
 * @author zhoushiya
 * @date 2020/7/9 18:33
 */
public class LambdaTest {

    @Test
    public void test1() {
        Runnable runnable = () -> System.out.println("asd");
        runnable.run();
    }

    @Test
    public void test2() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);
    }

    @Test
    public void test3() {
        Comparator<Integer> comparator = Integer::compare;
    }

    public void test4() {

    }
}

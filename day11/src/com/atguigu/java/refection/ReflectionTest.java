package com.atguigu.java.refection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {
    @Test
    public void test1() {
        Person p1 = new Person("Tom", 12);
        p1.age = 10;
        System.out.println(p1);
        p1.show();
    }

    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class clazz = Person.class;
        System.out.println(clazz.getName());
        // 构造器
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 12);
        System.out.println(tom);

        // 通过发射调取方法，修改age为10
        Field age = clazz.getDeclaredField("age");
        age.set(tom, 10);
        System.out.println(tom);

        // 调用方法
        Method show = clazz.getMethod("show");
        show.invoke(tom);

        // 通过反射，调用Person的私有结构
        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Object jerry = constructor1.newInstance("Jerry");
        System.out.println(jerry);
    }

    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一：
        Class clazz1 = Person.class;

        // 方式二：通过对象获取对象
        Person p1 = new Person();
        Class<? extends Person> clazz2 = p1.getClass();
        // 方式三：调用Class的静态方法
        Class<?> clazz3 = Class.forName("com.atguigu.java.refection.Person");

        // 方式四：使用类的加载器
        ClassLoader classLoader= ReflectionTest.class.getClassLoader();
        Class clazz4=classLoader.loadClass("com.atguigu.java.refection.Person");
        System.out.println(clazz4);
    }
}

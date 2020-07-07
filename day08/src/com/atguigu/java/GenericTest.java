package com.atguigu.java;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;

import java.util.*;

public class GenericTest {

    @Test
    public void test1() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 87);
        map.put("Jerry", 89);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry);
        }
    }

    @Test
    public void test2() {
        Person<Order> person = new Person("aaa", new Order(2));
        System.out.println(person);
    }

    @Test
    public void test3(){
        Student student=new Student("Alice",new Order(3));
        System.out.println(student);

        List<Student> studentList=new ArrayList<>();
        studentList.add(student);
        System.out.println(studentList);

        Student s2=studentList.get(0);
        System.out.println(s2);

        Object o=(Object)1;
        System.out.println(o);

        Student s= test4(student);
        System.out.println(s);
    }

    /**
     * 泛型方法
     * @param e
     * @param <E>
     */
    public <E extends Person> E test4(E e){
        return e;
    }

    public void test5(){
        List<? extends Person> list = new LinkedList<Student>();
        for (Person person : list) {

        }
    }
}

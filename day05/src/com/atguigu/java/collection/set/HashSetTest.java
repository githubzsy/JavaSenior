package com.atguigu.java.collection.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class HashSetTest {

    @Test
    public void test1(){
        Set set=new HashSet();
        set.add(123);
        set.add("CCC");
        set.add("AAA");

        for (Object obj : set){
            System.out.println(obj);
        }

        /**
         * AAA
         * CCC
         * 123
         */
    }

    @Test
    public void test2(){
        Set<Student> students=new HashSet<>();
        Student s1=new Student("A",10);
        Student s2=new Student("B",13);
        students.add(s1);
        students.add(s2);
        System.out.println(students);
        System.out.println("*******************");
        /**
         * [Student{name='A', age=10}, Student{name='B', age=13}]
         */
        s2.name="C";
        boolean r= students.remove(s2);

        System.out.println(students);
        /**
         * [Student{name='A', age=10}, Student{name='C', age=13}]
         * 移除s2并没有成功，原因：
         * 1.添加s2时根据name和age算出的hashCode(hashCode_1)决定了存放位置
         * 2.修改name了，导致s2的hashCode发生了改变(hashCode_2)，但是此时s2在Set中的位置还是没有改变的
         * 3.remove方法是拿s2的hashCode(hashCode_2)去查找对应地址，很明显是查找不到的，所以remove失败了
         */
        System.out.println(r);
        /**
         * false表明移除失败了
         */
        System.out.println("*******************");

        students.add(s2);
        System.out.println(students);
        /**
         * [Student{name='A', age=10}, Student{name='C', age=13}, Student{name='C', age=13}]
         * 能添加进去，道理与上面相同，计算hashCode得到hashCode_2，去查找存放位置，发现位置上没有数据，可以存入
         */
        System.out.println("*******************");

        Student s3=new Student("B",13);
        students.add(s3);
        System.out.println(students);
        /**
         * 能添加进去，先计算hashCode得到hashCode_1，确定了存放位置与s2相同
         * 然后再equals()比较s3与s2，发现不同，可以存入
         */
    }


}

class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        System.out.println("hashCode");
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.atguigu.java.collection.set;

import com.atguigu.java.collection.User;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test1() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(123);
        treeSet.add(4);

        treeSet.forEach(System.out::println);
    }

    @Test
    public void test2() {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new User("Alice",12));
        treeSet.add(new User("Bee",3));
        treeSet.add(new User("Bee",1));

        treeSet.forEach(System.out::println);
    }

    @Test
    public void test3() {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                /**
                 * 使用定制排序，根据age来
                 */
                if(o1 instanceof User && o2 instanceof User){
                    User user1=(User)o1;
                    User user2=(User)o2;
                    return user1.getAge().compareTo(user2.getAge());
                }
                else throw new RuntimeException("不可比较");
            }
        });
        treeSet.add(new User("Alice",12));
        treeSet.add(new User("Bee",3));
        treeSet.add(new User("Bee",1));
        treeSet.add(new User("cindy",3));

        treeSet.forEach(System.out::println);
        /**
         * User{name='Bee', age=1}
         * User{name='Bee', age=3}
         * User{name='Alice', age=12}
         * 定制排序判断元素是否相等，也是根据compare()方法
         */
    }
}

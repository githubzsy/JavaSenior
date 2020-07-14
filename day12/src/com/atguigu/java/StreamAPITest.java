package com.atguigu.java;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author zhoushiya
 * @date 2020/7/14 11:25
 */
public class StreamAPITest {

    @Test
    public void test1() {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            people.add(new Person(i, "lily" + i));
        }

        // 顺序流
        Stream<Person> stream = people.stream();
        stream.skip(10).filter(p -> p.getAge() < 100).filter(person -> person.getName().contains("1")).sorted(Comparator.comparingInt(Person::getAge)).forEach(System.out::println);

        // 并行流
        // map(Function f)接收一个函数作为参数，将元素转换成其他形式
        Stream<Integer> integerStream = people.parallelStream().map(Person::getAge);
        integerStream.filter(p->p<100).forEach(System.out::println);

        // flatMap(Function f) 接收一个函数作为参数，返回一个Stream流
        Stream<Integer> integerStream1 = Stream.of(Stream.of(4, 3), Stream.of(2, 1)).flatMap(a -> a);

        // 规约
        Optional<Integer> reduce = integerStream.reduce(Integer::sum);
        System.out.println(reduce);
    }

    public void fromStringToStream(String str){

    }

    @Test
    public void test2() {

        // 创建方式二：
        int[] ints = {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(ints);

        // 创建方式三：
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

    }

    @Test
    public void test4() {

        // 创建方式四
        // 无限流+终止操作
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}

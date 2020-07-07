package com.atguigu.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;
import java.util.ArrayList;

/**
 * 注解使用
 */
public class AnnotationDemo {
    public static void main(String[] args) {
    }
}

@MyAnnotation
class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

/**
 * 定义注解
 * 1.只有一个参数，建议使用value
 * 2.使用default定义默认值
 */
@Target({ElementType.TYPE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@Repeatable(MyAnnotations.class)
@interface MyAnnotation {
    String value() default "hello";
}

@Target(ElementType.TYPE)
@interface MyAnnotations {
    MyAnnotation[] value();
}

// TYPE_PARAMETER 注解
class Generic<@MyAnnotation T> {

    public void show() {
        // TYPE_USE 注解
        ArrayList<@MyAnnotation String> list = new ArrayList<>();

    }

}
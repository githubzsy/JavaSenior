package com.atguigu.java.collection;

public class User {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public int compareTo(Object o) {
//        if (o instanceof User) {
//            User user = (User) o;
//            int r = this.name.compareTo(user.name);
//            if (r == 0) {
//                return this.age.compareTo(user.age);
//            }
//            return r;
//        } else {
//            throw new RuntimeException("输入类型不匹配");
//        }
//    }
//
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

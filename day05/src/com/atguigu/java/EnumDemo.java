package com.atguigu.java;

public class EnumDemo {
    public static void main(String[] args) {
        Season.SUMMER.show();
    }
}

interface Info{
    void show();
}


enum  Season implements Info{
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println(this.name());
        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println(this.name());
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println(this.name());
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println(this.name());
        }
    };


    private final String seasonName;
    private final String seasonDesc;

    Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
}
package com.atguigu.java;

/**
 * 静态代理
 * 特点：代理类和被代理类在编译期间被确定
 */

interface ClothFactory{
    void produceCloth();
}

/**
 * 代理类
 */
class ProxyClothFactory implements ClothFactory{
    // 被代理类
    private ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory){
        this.factory=factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些收尾工作");
    }
}

/**
 * 被代理类
 */
class NikeFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产运动鞋");
    }
}



public class StaticProxyTest {
    public static void main(String[] args) {
        new ProxyClothFactory(new NikeFactory()).produceCloth();
    }
}

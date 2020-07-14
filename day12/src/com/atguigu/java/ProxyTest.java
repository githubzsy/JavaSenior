package com.atguigu.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理举例
 *
 * @author zhoushiya
 * @date
 */

interface Human {
    String getBelief();

    void eat(String food);
}

/**
 * 被代理类
 */
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

/**
 * 动态代理
 * 问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
 */
class ProxyFactory {
    /**
     * 调用此方法，返回一个代理类对象
     *
     * @param obj 被代理类的对象
     * @return 代理类实例
     */
    public static Object getProxyInstance(Object obj) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    /**
     * 被代理类的对象
     */
    private Object obj;

    public void bind(Object obj) {
        this.obj = obj;
    }

    /**
     * 当我们通过代理类的对象，调用方法a，就会自动的调用invoke()
     * 将被代理类要执行的方法a的功能声明在invoke()中
     *
     * @param proxy  代理类对象
     * @param method 要调用的的方法
     * @param args   参数
     * @return 调用的方法 {@code method} 的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(obj, args);
    }
}


public class ProxyTest {
    public static void main(String[] args) {
        // proxyInstance:代理类的对象
        Object proxyInstance = ProxyFactory.getProxyInstance(new SuperMan());
        Human humanProxyInstance = (Human) proxyInstance;
        System.out.println(humanProxyInstance.getBelief());
        humanProxyInstance.eat("火锅");

        ClothFactory nikeFactoryProxy = (ClothFactory) ProxyFactory.getProxyInstance(new NikeFactory());
        nikeFactoryProxy.produceCloth();
    }
}

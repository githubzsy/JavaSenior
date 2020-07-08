package com.atguigu.java.refection;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {
    @Test
    public void test1() {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        // 引导类加载器
        System.out.println(classLoader.getParent().getParent());
        System.out.println(String.class.getClassLoader());
    }

    /**
     * 读取配置文件方式一：
     * Properties:用来读取配置文件
     */
    @Test
    public void test2() {
        Properties properties = new Properties();
        // 默认路径在当前module下
        try (FileInputStream fileInputStream = new FileInputStream("jdbc.properties");) {
            properties.load(fileInputStream);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            System.out.println(user + ":" + password);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取配置文件方式二：
     * ClassLoader读取配置文件
     */
    @Test
    public void test3() {
        Properties properties = new Properties();
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        // 默认路径在当前module的src下
        try (InputStream inputStream = classLoader.getResourceAsStream("jdbc1.properties");) {
            properties.load(inputStream);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            System.out.println(user + ":" + password);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

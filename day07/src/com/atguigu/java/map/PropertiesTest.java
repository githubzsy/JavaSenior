package com.atguigu.java.map;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void test1() throws IOException {
        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream("test.properties");
        properties.load(fileInputStream);
        fileInputStream.close();
        String name =properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println(name);
        System.out.println(password);
    }
}

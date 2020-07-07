package com.atguigu.java.io;

import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStreamTest {
    /**
     * 序列化：将内存数据存储到磁盘文件中
     */
    @Test
    public void objectOutputStreamTest() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));) {

            objectOutputStream.writeObject("我爱北京天安门");
            objectOutputStream.flush();

            objectOutputStream.writeObject(new Person("张三", 4));
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 反序列化：将磁盘文件读取到内存中
     */
    @Test
    public void objectInputStreamTest() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));) {
            Object o = objectInputStream.readObject();
            System.out.println(o);

            o = objectInputStream.readObject();
            System.out.println(o);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

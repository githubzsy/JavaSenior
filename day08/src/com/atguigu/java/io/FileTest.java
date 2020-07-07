package com.atguigu.java.io;

import org.junit.Test;

import java.io.File;
import java.time.LocalDate;

public class FileTest {

    /**
     * 构造器测试
     */
    @Test
    public void test1() {
        // 相对路径，相对于module
        File file = new File("hello.txt");
        // 绝对路径
        File file2 = new File("d:/hello.txt");
        System.out.println(file);
        System.out.println(file2);

        // 拼接子目录
        File file3 = new File("D/www", "img");
        System.out.println(file3);

        // 目录+文件
        File file4 = new File(file3, "1.jpg");
        System.out.println(file4);
    }

    @Test
    public void test2(){
        File file1=new File("hello.txt");

        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.length());
        System.out.println(file1.lastModified());
        System.out.println(LocalDate.now());

        File directory=new File("d:/");

        for (File f : directory.listFiles()) {
            System.out.println(f);
        }
    }
}

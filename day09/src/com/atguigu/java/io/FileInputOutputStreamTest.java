package com.atguigu.java.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamTest {
    @Test
    public void fileInputStream() {
        try (FileInputStream fileInputStream = new FileInputStream("hello.txt")) {
            byte[] buffer = new byte[6];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                /**
                 * 中文会出现乱码，因为中文占3个字节，每次读取6个字节，刚好有可能将某个汉字的字节编码从中断开
                 */
                System.out.print(new String(buffer, 0, len));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fileCopyTest() {
        copy("图片.png", "图片-复制.png");
    }

    /**
     * 将源文件复制到目标文件
     *
     * @param src  源文件
     * @param dest 目标文件
     */
    public void copy(String src, String dest) {
        try (FileInputStream fileInputStream = new FileInputStream(src);
             FileOutputStream fileOutputStream = new FileOutputStream(dest);) {
            byte[] buffer = new byte[2 << 9];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copyTest() {
        long start = System.currentTimeMillis();
        copy("D:\\迅雷下载\\3DMyxklxbv2.0.rar", "D:\\迅雷下载\\3DMyxklxbv3.0.rar");

        long end = System.currentTimeMillis();
        System.out.println(end - start);
        // 7700
    }

    @Test
    public void test3() {
        long start = System.nanoTime();
        int i = 438;
        int j = i * 1024;

        long end = System.nanoTime();
        System.out.println("乘法所花时间:" + (end - start));

        long start2 = System.nanoTime();
        int a = 438;
        int b = i << 9;

        long end2 = System.nanoTime();
        System.out.println("位移运算所花时间:" + (end2 - start2));
    }
}

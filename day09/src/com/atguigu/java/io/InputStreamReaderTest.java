package com.atguigu.java.io;

import org.junit.Test;

import java.io.*;

public class InputStreamReaderTest {
    /**
     * 字节流转换为字符流
     */
    @Test
    public void test1() {
        try (FileInputStream fis = new FileInputStream("hello.txt");
             // 参数2指明了字符集，具体使用哪个字符集，取决于文件保存时的字符集
             InputStreamReader isr = new InputStreamReader(fis, "UTF-8");) {

            char[] buffer = new char[4];
            int len;
            while ((len = isr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将UTF-8转换为GBK的字符集
     */
    @Test
    public void test2() {
        try (FileInputStream fis = new FileInputStream("hello.txt");
             // 参数2指明了字符集，具体使用哪个字符集，取决于文件保存时的字符集
             InputStreamReader isr = new InputStreamReader(fis, "utf-8");
             FileOutputStream fos = new FileOutputStream("hello.gbk.txt");
             OutputStreamWriter osw = new OutputStreamWriter(fos, "GBK")) {

            char[] buffer = new char[4];
            int len;
            while ((len = isr.read(buffer)) != -1) {
                osw.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

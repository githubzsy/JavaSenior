package com.atguigu.java.io;

import org.junit.Test;

import java.io.*;

/**
 * 缓冲流的使用
 */
public class BufferedTest {
    /**
     * 使用缓冲流进行复制
     */
    public static void copyWithBuffer(String src,String dest) {
        try (FileInputStream fileInputStream = new FileInputStream(src);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream(dest);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void copyTest(){
        long start=System.currentTimeMillis();
        copyWithBuffer("D:\\迅雷下载\\3DMyxklxbv2.0.rar","D:\\迅雷下载\\3DMyxklxbv3.0.rar");

        long end=System.currentTimeMillis();
        System.out.println(end - start);    //2871
    }
}

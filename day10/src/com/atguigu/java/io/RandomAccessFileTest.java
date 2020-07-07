package com.atguigu.java.io;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    @Test
    public void test1() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("图片.png", "r");
             RandomAccessFile randomAccessFile2 = new RandomAccessFile("图片-复制.png", "rw");) {
            byte[] buffer = new byte[8096];
            int len;
            while ((len = randomAccessFile.read(buffer)) != -1) {
                randomAccessFile2.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 如果RandomAccessFile作为输出流，写出的文件不存在，则执行过程中自动创建
     * 如果写出文件存在，则对文件从头覆盖
     */
    @Test
    public void test2() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("abc.txt", "rw");) {
            // 从头覆盖
            randomAccessFile.write("xyz".getBytes());

            // 从末尾开始写入
            randomAccessFile.seek(randomAccessFile.getFilePointer());
            randomAccessFile.write("末尾".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("abc.txt", "rw");) {
            // 指针指到第三位
            randomAccessFile.seek(3);

            // 将后面的文字全部先保存
            StringBuilder builder = new StringBuilder((int) new File("abc.txt").length());
            byte[] buffer = new byte[8096];
            int len;
            while ((len = randomAccessFile.read(buffer)) != -1) {
                builder.append(new String(buffer, 0, len));
            }
            // 指针继续指到第三位
            randomAccessFile.seek(3);
            randomAccessFile.write("插入的数据".getBytes());
            // 开始写入数据
            randomAccessFile.write(builder.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

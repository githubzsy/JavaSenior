package com.atguigu.java.io;

import org.junit.Test;

import java.io.*;

public class FileReaderWriterTest {

    public static void main(String[] args) {
        /**
         * W:\Users\zhoushiya\IdeaProjects\JavaSenior\hello.txt
         * 相较于当前工程
         */
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void test1() {
        FileReader fileReader = null;
        try {
            /**
             * W:\Users\zhoushiya\IdeaProjects\JavaSenior\day09\hello.txt
             * 相较于当前module
             */
            File file = new File("hello.txt");
            fileReader = new FileReader(file);

            /**
             * read():返回读入的一个字符。如果达到文件末尾，则返回-1
             */
            int data;
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void fileReadTest2() {
        FileReader fileReader = null;
        try {
            /**
             * W:\Users\zhoushiya\IdeaProjects\JavaSenior\day09\hello.txt
             * 相较于当前module
             */
            File file = new File("hello.txt");
            fileReader = new FileReader(file);

            char[] buffer = new char[6];
            /**
             * read():返回读入的一个字符。如果达到文件末尾，则返回-1
             */
            int readLength;
            while ((readLength = fileReader.read(buffer)) != -1) {
                /**
                 * buffer每次装入不一定全部替换
                 * 例如第一次buffer是：asdasd
                 * 第二次buffer：是你傻吗？d
                 * 因为最后一位没有被替换
                 */
//                for (int i = 0; i < readLength; i++) {
//                    System.out.print(buffer[i]);
//                }
                System.out.print(new String(buffer, 0, readLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() {
        File file = new File("listen.txt");
        FileWriter writer = null;
        try {
            /**
             * false表示直接替换文件写入
             * true表示在文件末尾添加
             */
            writer = new FileWriter(file,true);

            writer.write("listen to me\n你好吗？");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

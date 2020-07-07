package com.atguigu.java.io;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * 标准输入输出流
 */
public class OtherStreamTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }


    @Test
    public void test1() {
        main(null);
    }

    @Test
    public void test2() {
        /**
         * 字节转换为字符，输入为键盘
         * 再用BufferedReader的readLine读取每一行字符
         */
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String data;
            StringBuilder stringBuilder = new StringBuilder();
            System.out.println("请输入字符串，以exit结束：");
            while ("exit".equalsIgnoreCase(data = bufferedReader.readLine()) == false) {
                stringBuilder.append(data).append(System.getProperty("line.separator"));
            }
            System.out.println("输入完毕，您输入的是：");
            System.out.println(stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try (FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
             PrintStream printStream = new PrintStream(fileOutputStream, true);) {
            /**
             * 将打印流的文件设置为当前输出路径
             */
            if(printStream!=null) System.setOut(printStream);
            for (int i = 0; i <=255; i++) {
                System.out.print((char)i);
                if(i%50==0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输出字符到文件
     */
    @Test
    public void dataOutputStreamTest(){
        try(DataOutputStream dos =new DataOutputStream(new FileOutputStream("dos.txt"))){
            dos.writeUTF("你好");
            dos.flush();
            dos.writeInt(32);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从文件中读取字符
     * 必须按照从上往下读
     */
    @Test
    public void dataInputStreamTest(){
        try(DataInputStream dis =new DataInputStream(new FileInputStream("dos.txt"))){
            String str= dis.readUTF();
            int age= dis.readInt();

            System.out.println(str);
            System.out.println(age);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

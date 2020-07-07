package com.atguigu.java.network;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpTest3 {

    static int PORT = 22223;


    @Test
    public void client() {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), PORT);
             OutputStream outputStream = socket.getOutputStream();
             FileInputStream fileInputStream = new FileInputStream("图片.png");
             InputStream inputStream = socket.getInputStream();
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            // 关闭数据流输出
            socket.shutdownOutput();
            System.out.println("图片已输出");

            buffer = new byte[1024];
            len = 0;
            while ((len = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer,0,len);
            }

            System.out.println(byteArrayOutputStream.toString());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void server() {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket socket = serverSocket.accept();
             InputStream inputStream = socket.getInputStream();
             FileOutputStream fileOutputStream = new FileOutputStream("图片-2.png");
             OutputStream outputStream = socket.getOutputStream();) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
            System.out.println("图片已接收");

            outputStream.write("信息已收到".getBytes());
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

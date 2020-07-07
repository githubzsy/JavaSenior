package com.atguigu.java.network;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpTest {

    static int PORT=22222;


    @Test
    public void client() {
        try (Socket socket = new Socket(InetAddress.getLocalHost(), PORT);
             OutputStream outputStream = socket.getOutputStream();) {
            outputStream.write("你好，我是你爸".getBytes());
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
             ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();) {
//            byte[] buffer = new byte[1024];
//            int len;
//            while ((len = inputStream.read(buffer)) != -1) {
//                String str=new String(buffer,0,len);
//                System.out.println(str);
//            }

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }

            System.out.println(byteArrayOutputStream.toString()+"\n收到了来自于"+socket.getInetAddress()+"的消息");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

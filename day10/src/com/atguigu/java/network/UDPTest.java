package com.atguigu.java.network;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class UDPTest {

    final static int PORT = 22225;

    @Test
    public void sender() {
        try (DatagramSocket datagramSocket = new DatagramSocket();) {
            byte[] data = "UDP数据发送".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(data, 0, data.length, InetAddress.getLocalHost(), PORT);
            datagramSocket.send(datagramPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void receiver() {
        try (DatagramSocket socket = new DatagramSocket(PORT);) {
            byte[] buffer = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);
            socket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

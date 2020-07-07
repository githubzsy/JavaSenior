package com.atguigu.java.network;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetAddressTest {

    @Test
    public void test1() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("192.168.31.1");
        System.out.println(inetAddress);

        InetAddress inetAddress1 = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress1);

        InetAddress localhost = InetAddress.getLocalHost();
        System.out.println(localhost);
    }
}

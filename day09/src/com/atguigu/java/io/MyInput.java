package com.atguigu.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyInput {

    public static String readString() {
        String data = null;
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            data = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }
}

package com.atguigu.java.io;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Nio2Test {
    @Test
    public void test1(){
        Path path=Paths.get("abc.txt");
        System.out.println(path.getFileName());
        System.out.println(path.getRoot());
        System.out.println(path.getParent());
    }
}

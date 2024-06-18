package com.atguigu.demo;

public class StringDemo {
    private static final String MESSAGE = "csdn";
    public static void main(String[] args) {
        String a = "cs" + "dn";
        String b = "cs";
        String c = "dn";
        System.out.println(a == MESSAGE);
        System.out.println((b + c) == MESSAGE);
    }
}

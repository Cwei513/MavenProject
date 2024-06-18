package com.atguigu.interview;

import java.util.Scanner;

/**
 * @Author : chen wei
 * @Date : 2024/06/08 17:39
 * @Version: 1.0
 * @Description :
 */
public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数");
        long l = scanner.nextLong();
        System.out.println("请输入一个字符串");
        String s = scanner.next();
        System.out.println("输入的整数为："+l+"，输入的字符串为："+s);

        Demo demo = new Demo();
        demo.test();
    }

    void test(){
        //生成一个随机数
        int i = (int) (Math.random() * 100);
        System.out.println("随机数是："+i);
        StringBuffer stringBuffer = new StringBuffer("hello");
        stringBuffer.append("world");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.toString());
        System.out.println(stringBuffer.reverse().toString());


    }

}

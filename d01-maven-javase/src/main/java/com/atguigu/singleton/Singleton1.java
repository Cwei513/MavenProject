package com.atguigu.singleton;

/**
 * @Author : chen wei
 * @Date : 2024/06/16 12:17
 * @Version: 1.0
 * @Description :
 */
public class Singleton1 {
    private static Singleton1 singleton1;
    private Singleton1(){}

    public static Singleton1 getInstance(){
        if (singleton1 == null){
            synchronized (Singleton1.class){
                if (singleton1 == null){
                    singleton1 = new Singleton1();
                }
            }
        }
        return singleton1;
    }
}

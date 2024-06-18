package com.atguigu.singleton;

/**
 * @Author : chen wei
 * @Date : 2024/06/12 17:25
 * @Version: 1.0
 * @Description :   单例模式---懒汉式
 */
public class LazySingleton {
    private static LazySingleton instance ;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if (null == instance ){
            synchronized (LazySingleton.class){
                if(null == instance){
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

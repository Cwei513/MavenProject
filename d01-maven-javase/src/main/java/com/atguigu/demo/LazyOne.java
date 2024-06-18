package com.atguigu.demo;

/***
 * @author : chen wei
 * @date   : 2024/4/17 3:54
 * @Version: 1.0
 * @Description   : 懒汉单例模式
 *
 */
public class LazyOne {
    private static LazyOne instance;
    private LazyOne(){}
    public static LazyOne getInstance(){
        if (instance == null){
            synchronized (LazyOne.class){
                if (instance == null){
                    instance = new LazyOne();
                }
            }
        }
        return instance;
    }
}

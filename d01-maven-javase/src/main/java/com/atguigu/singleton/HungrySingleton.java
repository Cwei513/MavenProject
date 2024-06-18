package com.atguigu.singleton;/**
 * @Author  : chen wei
 * @Date    : 2024/06/12 17:22
 * @Version: 1.0
 * @Description :   单例模式---饿汉式
 */
public class HungrySingleton {
     //1.私有化构造器
     private HungrySingleton(){}
     //2.内部创建对象
     private  static HungrySingleton instanc = new HungrySingleton();
     //3.提供公共的访问方式
     public static HungrySingleton getInstance(){
         return instanc;
     }
}

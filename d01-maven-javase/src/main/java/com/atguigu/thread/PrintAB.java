package com.atguigu.thread;

/***
 * @author : chen wei
 * @date   : 2024/4/17 4:00
 * @Version: 1.0
 * @Description   : 交替打印a,b字符各五十次
 *
 * 线程A只打印a字符，线程B只打印b字符
 *
 */
public class PrintAB {
    //打印a字符
    public synchronized void printA(){
        for (int i = 1; i <= 50; i++) {
            System.out.println("A"+" - "+ i);
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //打印b字符
    public synchronized void printB(){
        for (int i = 1; i <= 50; i++) {
            System.out.println("B"+" - "+ i);
            this.notify();
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) {
        PrintAB charAB = new PrintAB();
        new Thread(()->{
            //打印字符A
            charAB.printA();
        }).start();
        new Thread(()->{
            //打印字符B
            charAB.printB();
        }).start();

    }
}

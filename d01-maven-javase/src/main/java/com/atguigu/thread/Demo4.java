package com.atguigu.thread;

import java.util.concurrent.TimeUnit;

/***
 * @author : chen wei
 * @date   : 2024/4/17 1:27
 * @Version: 1.0
 * @Description   :  卖票
 */
public class Demo4 {
    // 票的数量
    private int stock = 100;

    // 卖票的方法
    public synchronized void saleTicket(){
        if (stock>0){
            System.out.println(Thread.currentThread().getName() + "卖了一张票，还剩" + --stock + "张票");
        }else {
            System.out.println("票卖完了");
        }
    }

    public static void main(String[] args) {
        Demo4 demo = new Demo4();

        // 开三个窗口卖票
        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}
                demo.saleTicket();
            }
        }, "0001").start();

        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}
                demo.saleTicket();
            }
        }, "0002").start();

        new Thread(()->{
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {}
                demo.saleTicket();
            }
        }, "0003").start();

    }
}

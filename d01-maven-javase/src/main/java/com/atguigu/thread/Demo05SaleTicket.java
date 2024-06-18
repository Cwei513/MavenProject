package com.atguigu.thread;

import java.util.concurrent.TimeUnit;

/**
 * 卖票
 */
public class Demo05SaleTicket {

    // 票库存数量
    private int stock = 10;

    // 声明卖票的方法
    public synchronized void saleTicket() {
        if (stock > 0) {
            System.out.println(Thread.currentThread().getName() + " 号窗口操作：还剩" + --stock + "张票，");
        }else{
            System.out.println("票卖完了！！！");
        }
    }

    public static void main(String[] args) {

        // 创建当前类的对象
        Demo05SaleTicket demo = new Demo05SaleTicket();

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
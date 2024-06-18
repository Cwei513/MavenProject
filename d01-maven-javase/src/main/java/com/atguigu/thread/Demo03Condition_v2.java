package com.atguigu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * @author : chen wei
 * @date   : 2024/5/5 0:14
 * @Version: 1.0
 * @Description   : 一个线程打印连续数字，一个线程打印连续字母。要求打印两个数字，然后打印两个字母，如此往复。
 *              12ab34cd56ef78gh ……
 */
public class Demo03Condition_v2 {
    // 打印数字的线程要打印的数字
    private int  digital  = 1;
    // 打印字母的线程要打印的字母
    private char alphaBet = 'a';

    // 同步锁对象
    Lock lock = new ReentrantLock();

    // 条件对象：对应打印数字的线程
    private Condition conditionDigital = lock.newCondition();
    // 条件对象：对应打印字母的线程
    private Condition conditionAlphaBet = lock.newCondition();

    // 声明一个方法专门打印数字
    public void printDigital(){
        try {
            lock.lock();
            // 唤醒打印字母的线程
            conditionAlphaBet.signal();
            // 打印数字
            System.out.print(digital++);
            System.out.print(digital++);
            // 让当前线程等待
            conditionDigital.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    // 声明一个方法专门打印字母
    public void printAlphaBet(){
        try {
            lock.lock();
            // 唤醒打印数字的线程
            conditionDigital.signal();
            // 打印数字
            System.out.print(alphaBet++);
            System.out.print(alphaBet++);
            // 让当前线程等待
            conditionAlphaBet.await();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo03Condition_v2 demo = new Demo03Condition_v2();

        new Thread(()->{
            while (true){
                demo.printDigital();
            }
        }).start();

        new Thread(()->{
            while (true){
                demo.printAlphaBet();
            }
        }).start();
    }


}

package com.atguigu.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/***
 * @author : chen wei
 * @date   : 2024/5/5 0:08
 * @Version: 1.0
 * @Description   : 读写锁---读锁
 *
 */
public class ReadWriteLockDemo01 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    public void readOperation() {
        try {
            readLock.lock();
            for (int i = 0; i < 5; i++) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + " is reading");
            }
        } catch (InterruptedException e) {
        } finally {
            readLock.unlock();
        }
    }

    public static void main(String[] args) {

        ReadWriteLockDemo01 demo = new ReadWriteLockDemo01();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                demo.readOperation();
            }, "thread" + i).start();
        }

    }
}

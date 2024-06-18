package com.atguigu.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author : chen wei
 * @Date : 2024/06/12 12:58
 * @Version: 1.0
 * @Description :
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.创建三个FutureTask对象，封装三个线程的执行逻辑
        FutureTask<Integer> task01 = new FutureTask<>(() -> {

            int result = (int) (Math.random() * Math.random() * 100);

            System.out.println(Thread.currentThread().getName());

            return result;
        });
        FutureTask<Integer> task02 = new FutureTask<>(() -> {

            int result = (int) (Math.random() * Math.random() * 1000);

            System.out.println(Thread.currentThread().getName());

            return result;
        });
        FutureTask<Integer> task03 = new FutureTask<>(() -> {

            int result = (int) (Math.random() * Math.random() * 10000);

            System.out.println(Thread.currentThread().getName());

            return result;
        });

// 2.创建三个线程对象，然后启动线程
        new Thread(task01, "thread01").start();
        new Thread(task02, "thread02").start();
        new Thread(task03, "thread03").start();

// 3.上面三个线程执行完成后，可以收集它们各自运算的结果
        Integer task01Result = task01.get();
        Integer task02Result = task02.get();
        Integer task03Result = task03.get();

        System.out.println("task01Result = " + task01Result);
        System.out.println("task02Result = " + task02Result);
        System.out.println("task03Result = " + task03Result);
    }

}

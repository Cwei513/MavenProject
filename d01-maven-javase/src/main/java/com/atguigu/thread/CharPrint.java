package com.atguigu.thread;

import java.util.concurrent.atomic.AtomicBoolean;
// 两个线程交替打印50个AB字母

public class CharPrint {
    private static final AtomicBoolean printingA = new AtomicBoolean(true);

    static class PrintAThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 50; i++) {
                while (!printingA.get()) {
                    Thread.yield(); // 让出CPU时间片，避免空转浪费资源
                }
                System.out.println("A - " + i);
                printingA.set(false);
            }
        }
    }

    static class PrintBThread extends Thread {
        @Override
        public void run() {
            for (int i = 1; i <= 50; i++) {
                while (printingA.get()) {
                    Thread.yield(); // 让出CPU时间片，避免空转浪费资源
                }
                System.out.println("B - " + i);
                printingA.set(true);
            }
        }
    }

    public static void main(String[] args) {
        PrintAThread printAThread = new PrintAThread();
        PrintBThread printBThread = new PrintBThread();

//        printAThread.start();
//        printBThread.start();

        new Thread(()->{
            for (int i = 1; i <= 50; i++) {
                while (!printingA.get()) {
                    Thread.yield(); // 让出CPU时间片，避免空转浪费资源
                }
                System.out.println("A - " + i);
                printingA.set(false);
            }
        }).start();
        new Thread(()->{
            for (int i = 1; i <= 50; i++) {
                while (printingA.get()) {
                    Thread.yield(); // 让出CPU时间片，避免空转浪费资源
                }
                System.out.println("B - " + i);
                printingA.set(true);
            }
        }).start();
    }
}

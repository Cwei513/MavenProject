package com.atguigu.thread;

public class PrintThread {

    public static void main(String[] args) throws InterruptedException {

        PrintOddThread printOddThread = new PrintOddThread();
        PrintEvenThread printEvenThread = new PrintEvenThread();
        printOddThread.start();
        printEvenThread.start();

        // 等待奇数线程执行完成
        printOddThread.join();

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        printEvenThread.setFlag(false);


    }
}

class PrintEvenThread extends Thread{

    private boolean flag = true;

    @Override
    public void run() {
        for (int i = 2; i < 100 && flag; i+=2) {
            System.out.println("偶数线程：" + i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

class PrintOddThread extends Thread{

    @Override
    public void run() {

        for (int i = 1; i < 100 ; i+=2) {
            System.out.println("奇数线程：" + i);
        }

    }
}

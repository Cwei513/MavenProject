package com.atguigu.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/***
 * @author : chen wei
 * @date   : 2024/5/5 3:04
 * @Version: 1.0
 * @Description   :
 *      一个线程打印连续数字，一个线程打印连续字母。要求打印两个数字，然后打印两个字母，如此往复。
 *      12ab34cd56ef78gh ……
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
            // runAsync()方法,有返回值，返回值为null
            //return 123;
        });
        System.out.println(runAsync.get());

        CompletableFuture<String> supplyAsync = CompletableFuture.supplyAsync(() -> {
            // supplyAsync()方法，有返回值
            return "123";
        });
        System.out.println(supplyAsync.get());
    }
}

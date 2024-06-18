package com.atguigu.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/***
 * @author : chen wei
 * @date   : 2024/5/31 8:37
 * @Version: 1.0
 * @Description   : 
 *
 */
public class CompletableFutureDemo1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 =
                CompletableFuture.supplyAsync(() -> "小王");
        CompletableFuture<String> future2 =
                CompletableFuture.supplyAsync(() -> "小张");
        CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future1, future2);
//        System.out.println(anyOf.get());
        System.out.println(anyOf.get());
    }
}

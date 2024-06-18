package com.atguigu.demo;

/***
 * @author : chen wei
 * @date   : 2024/3/13 17:04
 * @Version: 1.0
 * @Description   : 
 *
 */
public class Demo {
    public static void main(String[] args) {
        try {
            System.out.print("try-");
            int[] a = new int[0];
            a[0] = 1;
            System.out.print(a[0] + "-");
            return;
        } catch (Exception e) {
            System.out.print("catch-");
        } finally {
            System.out.print("finally");
        }
    }
}
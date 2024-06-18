package com.atguigu;

import org.junit.Test;

/***
 * @author : chen wei
 * @date   : 2024/5/8 2:30
 * @Version: 1.0
 * @Description   : 
 *
 */
public class MainTest {
    @Test
    public void test01(){
        System.out.println("hello world");
    }

    @Test
    public void test02(){
        int n = 10;
        n += (n++) + (++n);
        System.out.println(n);
    }
}

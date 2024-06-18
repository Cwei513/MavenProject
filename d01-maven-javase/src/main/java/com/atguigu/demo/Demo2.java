package com.atguigu.demo;

import java.util.*;

/***
 * @author : chen wei
 * @date   : 2024/4/10 3:58
 * @Version: 1.0
 * @Description   : 对集合进行操作引发并发修改异常
 *
 */
public class Demo2 {
    //对集合进行操作引发并发修改异常
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for (Integer integer : list) {
//            list.add(4);
//            list.remove(2);
            if (integer.equals(2)){
                int i = list.indexOf(integer);
                list.set(i,222);
            }
        }
        System.out.println(list);
        Integer i = new Integer(11);

        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list1 = Arrays.asList(s);
        Collections.reverse(list1);
        //没有指定类型的话会报错
        s=list1.toArray(new String[0]);
        for (String a: s) {
            System.out.println(a);

        }

    }

}

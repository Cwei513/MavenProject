package com.atguigu.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @author : chen wei
 * @date   : 2024/4/16 1:53
 * @Version: 1.0
 * @Description   :
 * 在 Java 中，int 是一个基本数据类型，而 Integer 是一个对象类型（装箱类型）。
 * 当你将 int 类型的数组传递给 Arrays.asList() 方法时，它会将整个 int 数组视为一个对象，
 * 而不是数组的每个元素视为一个独立的对象。这就是为什么在之前的情况下会出现 ArrayIndexOutOfBoundsException
 * 异常的原因，因为列表实际上只包含了一个元素，即整个 int 数组。
 *
 * 而当你将 int 类型的数组改为 Integer 类型的数组时，Integer 是对象类型，
 * 因此 Arrays.asList() 方法会将每个 Integer 元素都作为列表中的一个独立元素，
 * 而不是整个数组作为一个元素。因此，不会出现之前的 ArrayIndexOutOfBoundsException 异常
 *
 */
public class Demo3 {
    public static void main(String[] args) {
//        int[] myArray = {1, 2, 3};
        Integer[] myArray = {1, 2, 3};
        List myList = Arrays.asList(myArray);
        System.out.println(myList.size());//1
        System.out.println(myList.get(0));//数组地址值
        System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
//        int[] array = (int[]) myList.get(0);
//        System.out.println(array[0]);//1
        System.out.println(myList.toString());

        System.out.println("--------------------");

        int [] myArray2 = {1,2,3};
        List<Integer> collect = Arrays.stream(myArray2).boxed().collect(Collectors.toList());
        System.out.println(collect);


        System.out.println("--------数组转为集合------------");
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list1 = Arrays.asList(s);
        Collections.reverse(list1);
        //没有指定类型的话会报错
        s=list1.toArray(new String[0]);
        for (String s1 : s) {
            System.out.println(s1);

        }


    }
}

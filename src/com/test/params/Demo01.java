package com.test.params;

import org.junit.Test;

import java.math.BigInteger;

public class Demo01 {
    /**
     * 方法之间传递参数
     * 1.引用
     * 2.值  传递地址值 -----传递数组地址，传递对象地址，类地址
     */

    public static void main(String[] args) {
        int number1 = 100;
        int number2 = 90;
        exchange(number1,number2);
        System.out.println("交换后的值number1:"+number1+"交换后的值number2:"+number2);

        //引用传递
        int[] array = {1,2,3};
        //调用方法之前
        for (int i = 0; i <array.length ; i++) {
            System.out.println("调用方法之前--第"+(i+1)+"的值"+array[i]);
        }
        add(array);// 调用方法

        //调用方法之后
        for (int i = 0; i <array.length ; i++) {
            System.out.println("调用方法之后--第"+(i+1)+"的值"+array[i]);
        }
    }

    /**
     * 引用传递
     * @param array
     */
    public static  void add(int[] array){
        for (int i = 0; i <array.length ; i++) {
            array[i] += 10;
            System.out.println("执行方法 ---第"+(i+1)+"的值"+array[i]);
        }
    }

    /**
     * 值传递
     */
    public static void exchange(int num1, int num2){
        int temp;
        temp = num1;
        num1 = num2;
        System.out.println("交换后的值num1:"+num1+"交换后的值num2:"+num2);
    }
}

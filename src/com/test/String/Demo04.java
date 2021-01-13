package com.test.String;

import org.junit.Test;

public class Demo04 {
    public static void main(String[] args) {
        /**
         * 获取字符串长度，以及获取指定字符串
         */
        //定义字符串
        String s = "helloworld";

        //int.length() 获取字符串长度
        System.out.println("s.length:"+s.length());// 10
        System.out.println("--------------------");

        // char charAt(int index):获取指定索引位置的字符
        System.out.println("charAt:"+s.charAt(7));// r
        System.out.println("--------------------");

        // int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。
        System.out.println("indexof"+s.indexOf('l'));// 2
        System.out.println("--------------------");

        // int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
        System.out.println("indexOf:" + s.indexOf("owo"));// 4
        System.out.println("----------------------");

        // int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
        System.out.println("indexOf:" + s.indexOf('l', 4));//8
        System.out.println("indexOf:" + s.indexOf('o', 5));//6
        System.out.println("indexOf:" + s.indexOf('k', 4)); // -1
        System.out.println("indexOf:" + s.indexOf('l', 40)); // -1
        System.out.println("----------------------");

        // String substring(int start):从指定位置开始截取字符串
        System.out.println("substring:" + s.substring(5));
        System.out.println("substring:" + s.substring(0));
        System.out.println("----------------------");

        // String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。包括start索引但是不包end索引
        System.out.println("substring:" + s.substring(3, 8));
        System.out.println("substring:" + s.substring(0, s.length()));
    }
}

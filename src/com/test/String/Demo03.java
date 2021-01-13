package com.test.String;

import org.junit.Test;

public class Demo03 {
    public static void main(String[] args) {
        /**
         * 字符串若是变量相加，先申请空间，再拼接。
         * 字符串若是常量相加，是先加，然后在常量池找，如果有就直接返回，否则创建。
         */
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        System.out.println(s3 == s1 + s2);// false
        System.out.println(s3.equals((s1 + s2)));// true

        System.out.println(s3 == "hello" + "world");// true
        System.out.println(s3.equals("hello" + "world"));// true

    }
}

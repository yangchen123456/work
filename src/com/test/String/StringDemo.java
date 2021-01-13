package com.test.String;

import org.junit.Test;

public class StringDemo {
    public static void main(String[] args) {
        String s = "hello";
        s += "world";
        System.out.println("s:"+s);
        System.out.println("-------------");
        /**
         * ==:比较引用类型比较的是地址值是否相同
         * equals:比较引用类型默认也是比较地址值是否相同，
         * 而String类重写了equals()方法，比较的是内容是否相同。
         */
        String s1 = new String("hello");
        String s2 = "hello";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

}

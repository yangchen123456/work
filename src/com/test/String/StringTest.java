package com.test.String;

public class StringTest {
    public static void main(String[] args) {
        //public String();空构造
        String s1 = new String();
        System.out.println("s1"+s1);
        System.out.println("s1.length"+s1.length());
        System.out.println("-------------------");

        //public String(byte[] bytes); 将字节数组转化为字符串
        byte[] bys ={97,98,99,100,101};
        String s2 = new String(bys);
        System.out.println("s2"+s2);
        System.out.println("s2.length"+s2.length());
        System.out.println("-------------------");

        // public String(byte[] bytes,int index,int length):把字节数组的一部分转成字符串
        // 我想得到字符串"bcd"
        String s3 = new String(bys,1,3);
        System.out.println("s3"+s3);
        System.out.println("s3.length"+s3.length());
        System.out.println("-------------------");

        // public String(char[] value):把字符数组转成字符串
        char[] chs = {'a','b','c','d','e','杨','辰'};
        String s4 = new String(chs);
        System.out.println("s4"+s4);
        System.out.println("s4.length"+s4.length());
        System.out.println("-------------------");

        // public String(char[] value,int index,int count):把字符数组的一部分转成字符串
        String s5 = new String(chs,2,4);
        System.out.println("s5"+s5);
        System.out.println("s5.length"+s5.length());
        System.out.println("-------------------");

        //public String(String original):把字符串常量值转成字符串
        String s6 = new String("abcde");
        System.out.println("s6"+s6);
        System.out.println("s6.length"+s6.length());
        System.out.println("-------------------");

        //字符串字面值"abc"也可以看成是一个字符串对象
        String s7 = "abcde";
        System.out.println("s7"+s7);
        System.out.println("s7.length"+s7.length());

        // 去掉首尾的空格 String.trim
        String name = "   yang   ";
        String uname = name.trim();
        System.out.println(uname.length());

        // 去掉所有的空格 str.replace(" ", ""); 去掉所有空格，包括首尾、中间
        String user = "   ya  ng   ";
        String uuser = user.replace(" ", "");
        System.out.println(uuser.length());
    }
}

package com.test.String;

import org.junit.Test;

public class Demo07 {
    public static void main(String[] args) {
        /**
         * String功能：
         * * 替换功能：
         * String replace(char old,char new)
         * String replace(String old,String new)
         *
         * 去除字符串两端空格
         * String trim()
         *
         * 按字典顺序比较两个字符串
         * int compareTo(String str)
         * int compareToIgnoreCase(String str)
         */
            //替换功能
            String s1 = "helloworld";
            String s2 = s1.replace('l','y');
            String s3 = s1.replace("owo","yang");
            System.out.println("s1:"+s1);
            System.out.println("s2:"+s2);
            System.out.println("s3:"+s3);

            // 去掉首尾的空格 String.trim
            String name = "   yang   ";
            String newname = name.trim();
            System.out.println(newname.length());

            // 去掉所有的空格 str.replace(" ", ""); 去掉所有空格，包括首尾、中间
            String user = "   ya  ng   ";
            String newuser = user.replace(" ", "");
            System.out.println(newuser.length());
    }
}

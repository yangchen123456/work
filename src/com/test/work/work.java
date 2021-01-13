package com.test.work;

import java.io.UnsupportedEncodingException;

public class work {
    public static void main(String[] args) {
        //定义中文字符
        String name = "杨公辰";

        String uname = "";
        uname += "[";
        // 将name转化为数组
        char[] chars = name.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                uname += chars[i];
            }else {
                uname += chars[i];
                uname += ",";
            }
        }
        uname += "]";
        
        char[] chars1 = uname.toCharArray();
        System.out.println(chars1);
    }
    }



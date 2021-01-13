package com.test.String;

import org.junit.Test;

public class Demo06 {
    public static void main(String[] args) {
        /**
         * 		A:先获取第一个字符
         * 		B:获取除了第一个字符以外的字符
         * 		C:把A转成大写
         * 		D:把B转成小写
         * 		E:C拼接D
         */
        String s = "yangCHEN";
        String result = s.substring(0,1).toUpperCase()
                .concat(s.substring(1).toLowerCase());
        System.out.println(result);
    }
}

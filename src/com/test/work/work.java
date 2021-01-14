package com.test.work;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class work {
    public static void main(String[] args) {
        //定义中文字符
        String name = "杨公辰";

        String[] split = name.split("");
        System.out.println(Arrays.toString(split));

        System.out.println(split.length);
        System.out.println(split[0]);

    }
    }



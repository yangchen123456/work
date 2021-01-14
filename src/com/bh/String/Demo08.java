package com.bh.String;

public class Demo08 {
    public static void main(String[] args) {
            // 定义大串
            String maxString = "woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun";
            // 定义小串
            String minString = "java";

            // 写功能实现
            int count = getCount(maxString, minString);
            System.out.println("Java在大串中出现了：" + count + "次");
    }
    public static int getCount(String maxString,String minString){
        int count = 0;
        int index;

        while ((index=maxString.indexOf(minString))!=-1){
            count++;
            maxString = maxString.substring(index + minString.length());
        }
        return count;
    }
}

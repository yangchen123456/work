package com.bh.work;

public class work {
    public static void main(String[] args) {
        //定义中文字符
        String name = "杨公辰";
        //转化为字节数组
        byte[] bytes = name.getBytes();
        System.out.print("[");
        for (int i = 0; i <bytes.length ; i++) {
            if(i==bytes.length-1){
                System.out.print(bytes[i]);
            }else{
                System.out.print(bytes[i]+",");
            }
        }
        System.out.print("]");
    }
    }



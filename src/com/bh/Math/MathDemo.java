package com.bh.Math;

import org.junit.Test;

import java.util.Scanner;

public class MathDemo {
    /**
     * Math:用于数学运算的类。
     * 成员变量：
     * public static final double PI
     * public static final double E
     * 成员方法：
     * public static int abs(int a)：绝对值
     * public static double ceil(double a):向上取整
     * public static double floor(double a):向下取整
     * public static int max(int a,int b):最大值 (min类同)
     * public static double pow(double a,double b):a的b次幂
     * public static double random():随机数 [0.0,1.0)
     * public static int round(float a) 四舍五入(参数为double)
     * public static double sqrt(double a):正平方根
     */
    public static void main(String[] args) {
        // public static final double PI
        System.out.println("PI:" + Math.PI);
        // public static final double E
        System.out.println("E:" + Math.E);
        System.out.println("--------------");

        // public static int abs(int a)：绝对值
        System.out.println("abs:" + Math.abs(20));
        System.out.println("abs:" + Math.abs(-20));
        System.out.println("--------------");

        // public static double ceil(double a):向上取整
        System.out.println("ceil:" + Math.ceil(25.32));
        System.out.println("ceil:" + Math.ceil(25.32));
        System.out.println("--------------");

        // public static double floor(double a):向下取整
        System.out.println("floor:" + Math.floor(25.32));
        System.out.println("floor:" + Math.floor(25.32));
        System.out.println("--------------");

        // public static int max(int a,int b):最大值
        System.out.println("max:" + Math.max(25, 32));
        // 需求：我要获取三个数据中的最大值
        // 方法的嵌套调用
        System.out.println("max:" + Math.max(Math.max(12, 23), 18));
        // 需求：我要获取四个数据中的最大值
        System.out.println("max:"
                + Math.max(Math.max(20, 58), Math.max(35, 57)));
        System.out.println("--------------");

        // public static double pow(double a,double b):a的b次幂
        System.out.println("pow:" + Math.pow(3, 5));
        System.out.println("--------------");

        // public static double random():随机数 [0.0,1.0)
        System.out.println("random:" + Math.random());
        // 获取一个1-100之间的随机数
        System.out.println("random:" + ((int) (Math.random() * 100) + 1));
        System.out.println("--------------");

        // public static int round(float a) 四舍五入(参数为double的自学)
        System.out.println("round:" + Math.round(12.34f));
        System.out.println("round:" + Math.round(12.56f));
        System.out.println("--------------");

        //public static double sqrt(double a):正平方根
        System.out.println("sqrt:" + Math.sqrt(4));

        /**
         ** 需求：请设计一个方法，可以实现获取任意范围内的随机数。
         *
         * 分析：
         * 		A:键盘录入两个数据。
         * 			int strat;
         * 			int end;
         * 		B:想办法获取在start到end之间的随机数
         * 			我写一个功能实现这个效果，得到一个随机数。(int)
         * 		C:输出这个随机数
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入开始数：");
        int start = sc.nextInt();
        System.out.println("请输入结束数：");
        int end = sc.nextInt();

        for (int i = 0; i < 20; i++) {
            //调用获取随机数的方法，传递参数
            int num = getRandom(start, end);
            System.out.println(num);
        }
    }

    //获取随机数的方法
    @Test
    public static int getRandom(int start, int end) {
        int number = (int) (Math.random() * (end - start + 1)) + start;
        return number;
    }
}

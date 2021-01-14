package com.bh.BigDecimal;

import java.math.BigDecimal;

public class BigDecimalDemo {
    /**
     * * 看程序写结果：
     *     这是因为float类型的数据存储和整数不一样导致的。它们大部分的时候，都是带有有效数字位。
     *
     *  * 由于在运算的时候，float类型和double很容易丢失精度，演示案例。所以，为了能精确的表示、计算浮点数，Java提供了BigDecimal
     *
     *  * BigDecimal类：不可变的、任意精度的有符号十进制数,可以解决数据丢失问题。
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);

        System.out.println(1.0 - 0.12);

        /**
         * 构造方法：
         * public BigDecimal(String val)
         *
         * public BigDecimal add(BigDecimal augend)
         * public BigDecimal subtract(BigDecimal subtrahend)
         * public BigDecimal multiply(BigDecimal multiplicand)
         * public BigDecimal divide(BigDecimal divisor)
         * public BigDecimal divide(BigDecimal divisor,int scale,int roundingMode):商，几位小数，如何舍取
         */
        BigDecimal bigDecimal = new BigDecimal("2");
        BigDecimal bigDecimal1 = new BigDecimal("13");
        //相加
        System.out.println("相加："+bigDecimal.add(bigDecimal1));
        //相减
        System.out.println("相减："+bigDecimal1.subtract(bigDecimal));
        //相乘
        System.out.println("相乘："+bigDecimal.multiply(bigDecimal1));
        //相除
        System.out.println("相除："+bigDecimal1.divide(bigDecimal));
        //相除
        System.out.println("相除："+bigDecimal1.divide(bigDecimal,4,1));
    }
}

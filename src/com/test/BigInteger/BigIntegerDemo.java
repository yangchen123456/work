package com.test.BigInteger;

import org.junit.Test;

import java.math.BigInteger;

public class BigIntegerDemo {
    /**
     * BigInteger:可超过Integer范围内的数据进行运算
     * <p>
     * 构造方法：
     * BigInteger(String val)
     */
    public static void main(String[] args) {
        //这几个测试，是为了简单超过int范围内，Integer就不能再表示

        Integer i = new Integer(100);
        System.out.println(i);
        // System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);

        Integer ii = new Integer("2147483647");
        System.out.println(ii);
        // NumberFormatException
        //Integer iii = new Integer("2147483648");
        //System.out.println(iii);

        // 通过大整数来创建对象
        BigInteger bi = new BigInteger("2147483648");
        System.out.println("bi:" + bi);
    }

    /**
     * public BigInteger add(BigInteger val):加
     * public BigInteger subtract(BigInteger val):减
     * public BigInteger multiply(BigInteger val):乘
     * public BigInteger divide(BigInteger val):除
     * public BigInteger[] divideAndRemainder(BigInteger val):返回商和余数的数组
     */
    @Test
    public void main() {
        BigInteger bi1 = new BigInteger("90");
        BigInteger bi2 = new BigInteger("50");
        System.out.println("加："+bi1.add(bi2));
        System.out.println("减："+bi1.subtract(bi2));
        System.out.println("乘："+bi1.multiply(bi2));
        System.out.println("除："+bi1.divide(bi2));

        BigInteger[] bigIntegers = bi1.divideAndRemainder(bi2);
        System.out.println("商为："+bigIntegers[0]+"余数为："+bigIntegers[1]);
    }
}

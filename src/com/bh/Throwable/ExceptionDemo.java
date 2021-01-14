package com.bh.Throwable;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo {
    /**
     * 异常：不正常
     * <p>
     * 程序的异常：Throwable
     * 严重问题：Error 不处理。这种问题一般都是很严重的，比如说内存溢出。
     * 问题：Exception
     * 编译期问题:不是RuntimeException的异常 必须进行处理的，因为不处理，编译不能通过。
     * 运行期问题:RuntimeException	这种问题也不处理，因为是开发者的问题，
     * 而且这个问题出现肯定是代码不够严谨，需要修正代码。
     * <p>
     * 程序出现问题，没有做任何处理，最终jvm会做出默认的处理。
     * 把异常的名称，原因及出现的问题等信息输出在控制台。
     * 同时会结束程序。
     */
    public static void main(String[] args) {
        int a = 10;
        int b = 0;

        try {
            System.out.println(a / b);
        } catch (ArithmeticException ae) {
            System.out.println("除数不能为0");
        }
        System.out.println("执行完毕");
        // 调用method()方法
        System.out.println("今天天气很好");
        try {
            method();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("但是不该有雾霾");

        // 调用method1()方法
        method1();
    }

    @Test
    public void method4() {
        int a = 10;
        int b = 0;
        int[] arr = {1, 2, 3};

        try {
            System.out.println(a / b);
            System.out.println(arr[-1]);
            System.out.println("这里出现了一个异常");
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("访问了不该的访问的索引");
        } catch (Exception e) {
            System.out.println("出问题了");
        }

        System.out.println("执行完毕");
    }

    @Test
    public void method3() {
        int a = 10;
        int b = 0;
        int[] arr = {1, 2, 3};

        try {
            System.out.println(arr[3]);
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("访问了不该的访问的索引");
        }

        System.out.println("over");
    }

    @Test
    // 两个异常
    public void method2() {
        int a = 10;
        int b = 0;
        try {
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("除数不能为0");
        }

        int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("访问了不该的访问的索引");
        }

        System.out.println("over");
    }

    // 编译期异常的抛出
    // 在方法声明上抛出，是为了告诉调用者，此处有问题。
    public static void method() throws ParseException {
        String s = "2014-11-20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(s);
        System.out.println(d);
    }

    // 运行期异常的抛出
    public static void method1() throws ArithmeticException {
        int a = 10;
        int b = 0;
        System.out.println(a / b);
    }

    /**
     * throws
     * 用在方法声明后，跟的是异常类名
     * 可以跟多个异常类名，用逗号隔开
     * 表示抛出异常，由该方法的调用者处理
     * throws表示出现异常的一种可能性，并不一定会发生异常
     * throw
     * 用在方法体内，跟的是异常对象
     * 只能抛出一个异常对象
     * 表示抛出异常，由方法体内的语句处理
     */
    @Test
    public void method5() {
        int a = 10;
        int b = 0;
        if (b == 0) {
            throw new ArithmeticException();
        } else {
            System.out.println(a / b);
        }
    }

    public static void method6() throws Exception {
        int a = 10;
        int b = 0;
        if (b == 0) {
            throw new Exception();
        } else {
            System.out.println(a / b);
        }
    }

    @Test
    // 测试method6()
    public void method6Tset() {
        try {
            method6();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * finally:
     * 被finally控制的语句体一定会执行
     * 注意：
     * 如果是执行finally之前jvm退出了，则不执行
     * <p>
     * A:格式
     * try...catch...finally...
     * B:用于释放资源，在IO流操作和数据库操作中会见到
     */
    @Test
    public void method7() {
        String s = "2014-11-20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = null;
        try {
            // System.out.println(10 / 0);
            d = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
            System.exit(0);// 退出
        } finally {
            System.out.println("这里的代码是执行的..........");
        }
        System.out.println(d);
    }

    public int method8() {
        int a = 10;
        try {
            System.out.println(a / 0);
            a = 20;
        } catch (ArithmeticException e) {
            a = 30;
            return a;
            /*
             * return a在程序执行到这一步时，不是return a而是return 30;返回路径形成
             * 但是后面还有finally，所以继续执行finally的内容，a=40
             * 再次回到以前的返回路径，继续走return 30;
             */
        } finally {
            a = 40;
            return a;//如果这样结果就是40
        }
    }

    @Test
    public void method8Test() {
        System.out.println(method8());
    }


}

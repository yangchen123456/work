package com.bh.Thread;

public class ThreadYieldTest {
    /**
     * public static void yield():暂停当前正在执行的线程对象，并执行其他线程
     */
    public static void main(String[] args) {
        // 创建线程对象
        ThreadYield ty1 = new ThreadYield();
        MyThread mt = new MyThread();

        //设置线程的优先级
        mt.setPriority(1);
        ty1.setPriority(10);

        //设置线程的名称
        mt.setName("王五");
        ty1.setName("张三");

        //启动线程
        mt.start();
        ty1.start();
    }
}

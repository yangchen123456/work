package com.bh.Thread.runnable;

public class RunnableTest {

    public static void main(String[] args) {
        // 创建创建MyRunnable类的对象
        MyRunnable mr = new MyRunnable();

        //创建Thread类的对象
        Thread th = new Thread(mr);

        //设置名称
        th.setName("杨");
        //启动线程
        th.start();
    }
}

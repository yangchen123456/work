package com.bh.Thread;

import java.util.Date;

public class MyThread extends Thread {

    /**
     *	进程：
     *		程序的运行过程，是系统进行资源分配和调用的独立单位。
     *		每一个进程都有它自己的内存空间和系统资源。
     *	线程：
     *		是进程中的单个顺序控制流，是一条执行路径
     *		一个进程如果只有一条执行路径，则称为单线程程序。
     *		一个进程如果有多条执行路径，则称为多线程程序。
     *
     *  并行和并发
     *		前者是逻辑上同时发生，指在某一个时间内同时运行多个程序。
     *		后者是物理上同时发生，指在某一个时间点同时运行多个程序。
     *
     * Java程序的运行原理：
     * 		由java命令启动JVM，JVM启动就相当于启动了一个进程。
     * 		接着有该进程创建了一个主线程去调用main方法。
     *
     * 思考题：
     * 		jvm虚拟机的启动是单线程的还是多线程的?
     *
     */

    /**
     * 需求：实现多线程的程序。
     * 如何实现
     * Java提供的类
     * 		Thread
     * 		有两种方式实现多线程
     *
     * 方式1：继承Thread类。
     * 步骤
     * 		A:自定义类MyThread继承Thread类。
     * 		B:MyThread类里面重写run()?
     * 			为什么是run()方法呢?  // go
     * 		C:创建对象
     * 		D:启动线程
     */

    public MyThread(String name){
        super(name);
    }
    public MyThread(){

    }

    public void run() {
        for (int x = 0; x < 10; x++) {
            System.out.println(getName() + ":" + x);
        }
    }
}

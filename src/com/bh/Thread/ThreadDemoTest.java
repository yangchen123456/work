package com.bh.Thread;

import org.junit.Test;

public class ThreadDemoTest {
    /**
     * C:创建对象
     * D:启动线程
     */
    public static void main(String[] args) {
        //创建线程对象
        MyThread my1 = new MyThread();
        MyThread my2 = new MyThread();

        // 启用线程
        my1.start();
        my2.start();
    }

    /**
     * 获取线程对象的名称
     * public final String getName():获取线程的名称。
     * 设置线程对象的名称
     * public final void setName(String name):设置线程的名称
     * <p>
     * 针对不是Thread类的子类中如何获取线程对象名称呢?
     * public static Thread currentThread():返回当前正在执行的线程对象
     * Thread.currentThread().getName()
     */
    @Test
    public void ThreadDemoTest() {
        // 创建线程对象
        //无参构造+setXxx()
//         MyThread my1 = new MyThread();
//         MyThread my2 = new MyThread();
        // //调用方法设置名称
//         my1.setName("yang");
//         my2.setName("chen");
//         my1.start();
//         my2.start();

        //带参构造方法为线程命名
        MyThread my1 = new MyThread("yang");
        MyThread my2 = new MyThread("chen");
        System.out.println(my1.getName());
        my1.start();
        my2.start();

        //获取main方法所在的线程对象的名称
        //遇到这种情况,Thread类提供了一个方法:
        //public static Thread currentThread():返回当前正在执行的线程对象
        System.out.println(Thread.currentThread().getName());
    }

    /**
     * public final void setDaemon(boolean on):将该线程标记为守护线程或用户线程。
     * 当正在运行的线程都是守护线程时，Java 虚拟机退出。 该方法必须在启动线程前调用。
     */
    @Test
    public void ThreadDemoTest1() {
        //构造方法为线程命名
        MyThread my1 = new MyThread("杨");
        MyThread my2 = new MyThread("辰");

        //设置守护线程
        my1.setDaemon(true);
        my2.setDaemon(true);

        //启动线程
        my1.start();
        my2.start();

        //设置当前正在执行的线程对象的名字
        Thread.currentThread().setName("杨公辰");

        for (int x = 0; x < 5; x++) {
            ////返回当前正在执行的线程名称
            System.out.println(Thread.currentThread().getName() + ":" + x);
        }
    }

    /**
     * public final void join():等待该线程终止。
     */
    @Test
    public void ThreadDemoTest2() {
        //构造方法为线程命名
        MyThread my1 = new MyThread("杨");
        MyThread my2 = new MyThread("公");
        MyThread my3 = new MyThread("辰");

        //启动线程
        my1.start();
        try {
            //等待线程终止
            my1.join();
            System.out.println(111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        my2.start();
        my3.start();
    }

    /**
     * 线程没有设置优先级,肯定有默认优先级。
     * 那么，默认优先级是多少呢?
     * 如何获取线程对象的优先级?
     * 		public final int getPriority():返回线程对象的优先级
     * 如何设置线程对象的优先级呢?
     * 		public final void setPriority(int newPriority)：更改线程的优先级。
     *
     * 注意：
     * 		线程默认优先级是5。
     * 		线程优先级的范围是：1-10
     *
     * IllegalArgumentException:非法参数异常。
     * 抛出的异常表明向方法传递了一个不合法或不正确的参数。
     *
     */
    @Test
    public void ThreadDemoTest3(){
        //构造方法为线程命名
        MyThread my1 = new MyThread("杨");
        MyThread my2 = new MyThread("公");
        MyThread my3 = new MyThread("辰");

        //返回默认优先级
        System.out.println(my1.getPriority()); //5
        System.out.println(my2.getPriority()); //5
        System.out.println(my3.getPriority()); //5

        //设置优先级-----线程优先级的范围是：1-10
        try {
            //my1.setPriority(1000); //错误演示
            my1.setPriority(1);
            my2.setPriority(10);
            my3.setPriority(3);

        }catch (IllegalArgumentException e){
            System.out.println("线程优先级范围为：1-10,请设置正确的优先级");
        }

        //启动线程
        my1.start();
        my2.start();
        my3.start();
    }

}

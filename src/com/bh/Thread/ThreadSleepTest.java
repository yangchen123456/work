package com.bh.Thread;

import org.junit.Test;

public class ThreadSleepTest {
    public static void main(String[] args) {
        /**
         * 线程休眠
         *		public static void sleep(long millis)
         */
        //构造方法为线程命名
        ThreadSleep ts1 = new ThreadSleep("杨");
        ThreadSleep ts2 = new ThreadSleep("公");
        ThreadSleep ts3 = new ThreadSleep("辰");


        //启动线程
        ts1.start();
        ts2.start();
        ts3.start();
    }
}

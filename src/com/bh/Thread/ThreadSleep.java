package com.bh.Thread;

import java.util.Date;

public class ThreadSleep extends Thread{
    public ThreadSleep(String name){
        super(name);
    }
    public ThreadSleep(){

    }

    public void run() {
        //线程休眠
        for (int x = 0; x < 100; x++) {
            System.out.println(getName() + ":" + x + ",日期：" + new Date());
            // 睡眠
            // 困了，休息1秒钟
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

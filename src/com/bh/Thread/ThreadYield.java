package com.bh.Thread;

import java.util.Date;

public class ThreadYield extends Thread{
    /**
     * public static void yield():暂停当前正在执行的线程对象，并执行其他线程
     */

    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println(getName()+""+i);
            // 暂停当前线程，执行其他线程
        }
    }
}

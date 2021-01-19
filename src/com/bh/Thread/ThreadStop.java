package com.bh.Thread;

import java.util.Date;

public class ThreadStop extends Thread {
    /**
     * public final void stop():线程停止，过时了，还可以使用。
     * public void interrupt():中断线程。 把线程的状态终止，并抛出一个InterruptedException。
     */
    public void run() {
        System.out.println("开始执行：" + new Date());

        // 休息10秒钟，不要打扰
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            // e.printStackTrace();
            System.out.println("线程被终止了");
        }

        System.out.println("结束执行：" + new Date());
    }
}

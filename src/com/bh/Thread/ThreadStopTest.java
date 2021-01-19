package com.bh.Thread;

public class ThreadStopTest {
    /**
     * public final void stop():线程停止，过时了，还可以使用。
     * public void interrupt():中断线程。 把线程的状态终止，并抛出一个InterruptedException。
     */
    public static void main(String[] args) {
        ThreadStop ts = new ThreadStop();
        ts.start();

        // 超过三秒不醒过来，后果自负...
        try {
            Thread.sleep(3000);
             //ts.stop();
            //终止线程
            ts.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package com.bh.Thread.runnable;

public class SellTicket1 implements Runnable {
    // 定义100张票
    // private int tickets = 100;
    // 为了让多个线程对象共享这100张票，应该用静态修饰
    private static int tickets = 100;
    //创建锁对象
    private Object obj = new Object();
    @Override
    public void run() {
        //一直有票
        while (true) {
            synchronized (obj) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        }
    }
}

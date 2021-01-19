package com.bh.Thread.runnable;

public class SellTicketTest1 {
    public static void main(String[] args) {
        // 创建资源对象
        SellTicket1 st = new SellTicket1();

        // 创建三个线程对象
        Thread th1 = new Thread(st, "窗口1");
        Thread th2 = new Thread(st, "窗口2");
        Thread th3 = new Thread(st, "窗口3");

        // 启动线程
        th1.start();
        th2.start();
        th3.start();

    }
}

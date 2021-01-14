package com.bh.Calendar;

import org.junit.Test;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarDemo {
    /**
     * Calendar:它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等
     * 日历字段之间的转换提供了一些方法，
     * 并为操作日历字段（例如获得下星期的日期）提供了一些方法。
     * <p>
     * public int get(int field):返回给定日历字段的值。
     * 日历类中的每个日历字段都是静态的成员变量，并且是int类型。
     */
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();// 子类对象
// 获取年
        int year = calendar.get(Calendar.YEAR);
        // 获取月
        int month = calendar.get(Calendar.MONTH);
        // 获取日
        int date = calendar.get(Calendar.DATE);

        System.out.println(year + "年" + (month + 1) + "月" + date + "日");
        // 调用 获取任意一年的二月有多少天的方法
        Calendar();
    }

    /**
     * 获取任意一年的二月有多少天
     * <p>
     * 分析：
     * A:键盘录入任意的年份
     * B:设置日历对象的年月日
     * 年就是A输入的数据
     * 月是2
     * 日是1
     * C:把时间往前推一天，就是2月的最后一天
     * D:获取这一天输出即可
     */
    public static void Calendar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入年份：");
        // 获取用户输入的年份
        int s = scanner.nextInt();

        Calendar instance = Calendar.getInstance();
        // 设置年月日
        instance.set(s, 2, 1);
        // 将date往前推一天
        instance.add(Calendar.DATE, -1);
        // 打印当前的date
        System.out.println(instance.get(Calendar.DATE));
    }
    /**
     * 10年后的5天前
     */
    @Test
    public void getData(){
        Calendar calendar = Calendar.getInstance();
        // 10年后的5天前
        calendar.add(Calendar.YEAR, 10);
        calendar.add(Calendar.DATE, -5);
        // 获取年
        int year = calendar.get(Calendar.YEAR);
        // 获取月
        int month = calendar.get(Calendar.MONTH);
        // 获取日
        int date = calendar.get(Calendar.DATE);
        System.out.println(year + "年" + (month + 1) + "月" + date + "日");
        System.out.println("--------------");
    }

    @Test
    public void getData1(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 1, 13);
        // 获取年
        int year = calendar.get(Calendar.YEAR);
        // 获取月
        int month = calendar.get(Calendar.MONTH);
        // 获取日
        int date = calendar.get(Calendar.DATE);
        System.out.println(year + "年" + month + "月" + date + "日");
    }
}


package com.test.Calendar;

import org.junit.Test;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarDemo {
    public static void main(String[] args) {
        // 其日历字段已由当前日期和时间初始化：
        Calendar rightNow = Calendar.getInstance(); // 子类对象
        // 获取年
        int year = rightNow.get(Calendar.YEAR);
        // 获取月
        int month = rightNow.get(Calendar.MONTH);
        // 获取日
        int date = rightNow.get(Calendar.DATE);

        System.out.println(year + "年" + (month + 1) + "月" + date + "日");

        Calendar();
    }

    public static void Calendar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入年份：");
        int s = scanner.nextInt();

        Calendar instance = Calendar.getInstance();
        instance.set(s,2,1);
        instance.add(Calendar.DATE,-1);

        System.out.println(instance.get(Calendar.DATE));

    }

}


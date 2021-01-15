package com.bh.Throwable;

public class TeacherTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Teacher p=new Teacher();
        try {
            p.setSex("Male");
        } catch (Exception e) {
            System.out.println("设置性别出错了");
            e.printStackTrace();//输出异常信息
        }
    }

}

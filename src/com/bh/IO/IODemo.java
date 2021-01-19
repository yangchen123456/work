package com.bh.IO;

import org.junit.Test;

import java.io.*;

public class IODemo {
    /**
     * IO流分类：
     * 流向：
     * 输入流	读取数据
     * 输出流 写出数据
     * 数据类型：
     * 字节流
     * 字节输入流	读取数据	InputStream
     * 字节输出流	写出数据	OutputStream
     * 字符流
     * 字符输入流	读取数据	Reader
     * 字符输出流	写出数据	Writer
     * <p>
     * 注意：默认情况下是按照数据类型分
     * <p>
     * 需求：要向文本文件中输入："hello,io"
     * <p>
     * <p>
     * <p>
     * 使用：OutputStream
     * 流对象是一个抽象类，不能实例化
     * 所以，要一个具体的子类。
     * 而要找的子类名称：
     * 文件：File
     * 然后用的是字节输出流：FileOutputStream
     * 注意：基类的子类都是以父类名作为后缀名。
     * XxxOutputStream
     * XxxInputStream
     * XxxReader
     * XxxWriter
     * FileOutputStream的构造方法：
     * FileOutputStream(File file)
     * FileOutputStream(String name)
     * <p>
     * 字节输出流操作步骤：
     * A:创建字节输出流对象
     * B:写数据
     * C:释放资源
     */
    public static void main(String[] args) throws IOException {
        // 创建字节输出流对象
        // FileOutputStream(File file)
        // File file = new File("fos.txt");
        // FileOutputStream fos = new FileOutputStream(file);
        // FileOutputStream(String name)
        FileOutputStream fos = new FileOutputStream("D:\\demo\\aa.txt");

        //写数据
        fos.write("yang gong chen".getBytes());
        fos.write("hello".getBytes());

        //释放资源
        //关闭此文件输出流并释放与此流有关的所有系统资源
        fos.close();
        /**
         * 一定要close()
         * A:流对象变成垃圾，就可以被垃圾回收器回收
         * B:通知系统去释放跟该文件相关的资源
         */
    }


    /**
     * 字节输出流操作步骤：
     * A:创建字节输出流对象
     * B:调用write()方法
     * C:释放资源
     * <p>
     * public void write(int b):写一个字节
     * public void write(byte[] b):写一个字节数组
     * public void write(byte[] b,int off,int len):写一个字节数组的一部分
     */
    @Test
    public void DemoTest() throws IOException {
        FileOutputStream stream = new FileOutputStream("D:\\demo\\aa.txt");

        // write()
        //stream.write(97);
        //stream.write(57);
        //stream.write(55);

        //public void write(byte[] b):写一个字节数组
        byte[] bys = {97, 98, 99, 100, 101};
//        stream.write(bys);

        //public void write(byte[] b,int off,int len):写一个字节数组的一部分
        stream.write(bys, 1, 3);

        // 释放资源
        stream.close();
    }

    /**
     * 实现换行
     * <p>
     * windows:\r\n
     * linux:\n
     * Mac:\r
     * 有些常见的个高级记事本，是可以识别任意换行符号的。
     * <p>
     * 如何实现数据的追加写入
     * 用构造方法带第二个参数是true的情况即可
     */
    @Test
    public void DemoTest1() throws IOException {
        FileOutputStream stream = new FileOutputStream("D:\\demo\\aa.txt", true);

        // 写入数据

        for (int i = 0; i < 10; i++) {
            stream.write(("hello" + i).getBytes());
            stream.write("\r\n".getBytes());
        }

        //释放资源
        stream.close();
    }

    /**
     * 加入异常处理的字节输出流操作
     */
    @Test
    public void DemoTest2() {
        // 在finally里面能够看到该对象则必须定义到外面，为了不出问题，必须给初始化值
        FileOutputStream stream = null;

        try {
            stream = new FileOutputStream("D:\\demo\\aa.txt", true);
            stream.write("yang chen".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //判断stream是否为null，如果不为null则关闭close()
            if (stream != null) {
                // 为保证close()一定会执行，就放到这里了
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 字节输入流操作步骤：
     * A:创建字节输入流对象
     * B:调用read()方法读取数据，并把数据显示在控制台
     * C:释放资源
     * <p>
     * 读取数据的方式：
     * A:int read():一次读取一个字节
     * B:int read(byte[] b):一次读取一个字节数组
     */
    @Test
    public void DemoTest3() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\demo\\aa.txt");

        int by = 0;
        // 读取，赋值，判断

        //read() :  从输入流中读取数据的下一个字节，返回0到255范围内的int字节值
        //如果因为已经到达流末尾而没有可用的字节，则返回-1。
        while ((by = fis.read()) != -1) {
            System.out.println((char) by);
        }

        fis.close();
    }

    /**
     * 一次读取一个字节数组：int read(byte[] b)
     * 返回值其实是实际读取的字节个数
     */
    @Test
    public void DemoTest4() throws IOException {
        // 创建字节输入流对象
        FileInputStream fis = new FileInputStream("D:\\demo\\aa.txt");

        byte[] bytes = new byte[1024];

        int by = 0;
        while ((by = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, by));
        }

        // 释放资源
        fis.close();

    }

    /**
     * 复制文本文件。
     * <p>
     * 数据源：
     * a.txt	--	读取数据	--	FileInputStream
     * <p>
     * 目的地：
     * b.txt	--	写数据		--	FileOutputStream
     * <p>
     * java.io.FileNotFoundException: a.txt (系统找不到指定的文件。)
     */
    @Test
    public void DemoTest5() throws IOException {
        // 封装数据源
        FileInputStream fis = new FileInputStream("D:\\demo\\aa.txt");

        // 封装目的地

        FileOutputStream fos = new FileOutputStream("D:\\demo\\bb.txt");

        File file = new File("D:\\demo\\bb.txt");
        int by = 0;

        // 判断文件是否存在
        if (!file.exists()) {
            // 文件不存在则创建文件
            file.createNewFile();
        }
        //循环读取然后写入文件
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        //释放资源
        fis.close();
        fos.close();
    }

    /**
     * 需求：把c盘下的a.txt的内容复制到d盘下的b.txt中
     * <p>
     * 数据源：
     * c:\\a.txt	--	读取数据--	FileInputStream
     * 目的地：
     * d:\\b.txt	--	写出数据	--	FileOutputStream
     */
    @Test
    public void DemoTest6() throws IOException {
        //封装数据源
        FileInputStream fis = new FileInputStream("D:\\demo\\aa.txt");

        FileInputStream fis1 = new FileInputStream("C:\\txt\\b.txt");
        // 封装目的地
        FileOutputStream fos = new FileOutputStream("C:\\txt\\b.txt");

        // 创建文件对象
        File file = new File("C:\\txt\\b.txt");
        int by = 0;
        //判断文件是否存在
        if (!file.exists()) {
            // 不存在则创建文件
            file.createNewFile();
        }
        //循环读取然后写入文件
        while ((by = fis.read()) != -1) {
            fos.write(by);

        }
        System.out.println("b.txt========");
        // 创建数组
        byte[] bys = new byte[1024];
        int b = 0;
        // 循环取出数据
        while ((b = fis1.read(bys)) != -1){
            System.out.println(new String(bys,0,b));
        }

        //关闭资源
        fis.close();
        fos.close();
    }
    /**
     * 需求：把e:\\xxx.jpg内容复制到当前项目目录下的mn.jpg中
     *
     * 数据源：
     * 		e:\\xxx.jpg	--读取数据--FileInputStream
     * 目的地：
     * 		mn.jpg--写出数据--FileOutputStream
     */
    @Test
    public void DemoTest7() throws IOException{
        //封装数据源
        FileInputStream fis = new FileInputStream("C:\\txt\\1.jpg");

        //封装目的地
        FileOutputStream fos = new FileOutputStream("mn.jpg");

        // 复制数据
        int by = 0;
        //循环读取然后写入文件
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        // 释放资源
        fos.close();
        fis.close();

    }

    /**
     * 需求：把e:\\xxx.mp4复制到当前项目目录下的copy.mp4中
     *
     * 数据源：
     * 		e:\\xxx.mp4--读取数据--FileInputStream
     * 目的地：
     * 		copy.mp4--写出数据--FileOutputStream
     */
    @Test
    public void DemoTest8() throws IOException{
        //封装数据源
        FileInputStream fis = new FileInputStream("C:\\txt\\1.mp4");

        //封装目的地
        FileOutputStream fos = new FileOutputStream("cop.mp4");

        int by =0;
        //循环读取然后写入文件
        while ((by = fis.read())!= -1){
            fos.write(by);
        }
        // 释放资源
        fis.close();
        fos.close();
    }

}

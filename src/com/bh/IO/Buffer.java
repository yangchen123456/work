package com.bh.IO;

import org.junit.Test;

import java.io.*;

public class Buffer {
    /**
     * 有一个缓冲区还是较为专业
     * <p>
     * 类被称为：缓冲区类(高效类)
     * 写数据：BufferedOutputStream
     * 读数据：BufferedInputStream
     * <p>
     * 构造方法可以指定缓冲区的大小，因为默认缓冲区大小就足够
     * <p>
     * 为什么不传递一个具体的文件或者文件路径，而是传递一个OutputStream对象
     * 原因是字节缓冲区流仅仅提供缓冲区，为高效而设计。但是真正的读写操作还得靠基本的流对象实现。
     */
    @Test
    public void BufferTest() throws IOException {
        // BufferedOutputStream(OutputStream out)
        // FileOutputStream fos = new FileOutputStream("bos.txt");
        // BufferedOutputStream bos = new BufferedOutputStream(fos);
        // 简单写法

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\demo\\aa.txt", true));

        // 写入数据
        bos.write("hello yangchen ".getBytes());

        //关闭资源
        bos.close();
    }

    /**
     * 需求：把e:\\xxx.mp4复制到当前项目目录下的copy.mp4中
     * <p>
     * 字节流四种方式复制文件：
     * 基本字节流一次读写一个字节：	共耗时：   毫秒
     * 基本字节流一次读写一个字节数组： 共耗时：毫秒
     * 高效字节流一次读写一个字节： 共耗时：毫秒
     * 高效字节流一次读写一个字节数组： 共耗时：毫秒
     */
    @Test
    public void BufferTest1() throws IOException {
        long start = System.currentTimeMillis();
        method1("C:\\txt\\1.mp4", "copy1.mp4");
        //基本字节流一次读写一个字节：	共耗时：25535毫秒

        //method2("C:\\txt\\1.mp4", "copy2.mp4");
        // 基本字节流一次读写一个字节数组： 共耗时：47毫秒

        //method3("C:\\txt\\1.mp4", "copy3.mp4");
        // 高效字节流一次读写一个字节： 共耗时：152毫秒

        //method4("C:\\txt\\1.mp4", "copy4.mp4");
        // 高效字节流一次读写一个字节数组： 共耗时：21毫秒
        long end = System.currentTimeMillis();
        System.out.println("共耗时：" + (end - start) + "毫秒");
    }


    // 高效字节流一次读写一个字节：
    public void method3(String srcString, String destString) throws IOException {
        //封装数据源
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
        // 封装目的地
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString));

        int by = 0;
        // 读取数据写入数据
        while ((by = bis.read()) != -1) {
            bos.write(by);
        }
        //关闭资源
        bos.close();
        bis.close();
    }

    // 高效字节流一次读写一个字节数组：
    public void method4(String srcString, String destString) throws IOException {
        //封装数据源
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcString));
        // 封装目的地
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destString, true));
        // 创建数组
        byte[] bys = new byte[1024];
        int by = 0;
        // 读取数据
        while ((by = bis.read(bys)) != -1) {
            bos.write(bys, 0, by);
        }
        // 关闭资源
        bos.close();
        bis.close();
    }

    // 基本字节流一次读写一个字节数组
    public static void method2(String srcString, String destString)
            throws IOException {
        //封装数据源
        FileInputStream fis = new FileInputStream(srcString);
        // 封装目的地
        FileOutputStream fos = new FileOutputStream(destString);

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = fis.read(bys)) != -1) {
            fos.write(bys, 0, len);
        }

        // 关闭资源
        fos.close();
        fis.close();
    }

    // 基本字节流一次读写一个字节
    public static void method1(String srcString, String destString)
            throws IOException {
        //封装数据源
        FileInputStream fis = new FileInputStream(srcString);
        // 封装目的地
        FileOutputStream fos = new FileOutputStream(destString);

        int by = 0;
        while ((by = fis.read()) != -1) {
            fos.write(by);
        }

        // 关闭资源
        fos.close();
        fis.close();
    }

    /**
     * InputStreamReader的方法：
     * int read():一次读取一个字符
     * int read(char[] chs):一次读取一个字符数组
     */

    @Test
    public void InputStreamReaderDemo() throws IOException {
        // 创建对象
        InputStreamReader isr = new InputStreamReader(new FileInputStream(
                "D:\\demo\\aa.txt"));

        int by = 0;
        // int read():一次读取一个字符
//        while ((by = isr.read())!= -1){
//            System.out.println((char) by);
//        }

        //int read(char[] chs):一次读取一个字符数组
        char[] bys = new char[1024];
        while ((by = isr.read(bys)) != -1) {
            System.out.println(new String(bys, 0, by));
        }
    }

    /**
     * OutputStreamWriter的方法：
     * public void write(int c):写一个字符
     * public void write(char[] cbuf):写一个字符数组
     * public void write(char[] cbuf,int off,int len):写一个字符数组的一部分
     * public void write(String str):写一个字符串
     * public void write(String str,int off,int len):写一个字符串的一部分
     * <p>
     * 面试题：close()和flush()的区别?
     * A:close()关闭流对象，但是先刷新一次缓冲区。关闭之后，流对象不可以继续再使用了。
     * B:flush()仅仅刷新缓冲区,刷新之后，流对象还可以继续使用。
     */

    @Test
    public void OutputStreamWriterDemo() throws IOException {
        // 创建对象
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
                "D:\\demo\\aa.txt", true));

        // 写数据
        // public void write(int c):写一个字符
        // osw.write('a');
        // osw.write(97);
        // 为什么数据没有进去呢?
        // 原因是：字符 = 2字节
        // 文件中数据存储的基本单位是字节。
        // void flush()

        // public void write(char[] cbuf):写一个字符数组
         char[] chs = {'a','b','c','d','e'};
         osw.write(chs);

        // public void write(char[] cbuf,int off,int len):写一个字符数组的一部分
         osw.write(chs,1,3);

        // public void write(String str):写一个字符串
        osw.write("yang chen");

        // public void write(String str,int off,int len):写一个字符串的一部分
        osw.write("yang chen", 2, 3);

        // 刷新缓冲区
        osw.flush();
        // osw.write("yang chen", 2, 3);

        // 释放资源
        osw.close();
        // java.io.IOException: Stream closed
        // osw.write("", 2, 3);
    }

    /**
     * 需求：把当前项目目录下的a.txt内容复制到当前项目目录下的b.txt中
     *
     * 数据源：
     * 		a.txt -- 读取数据 -- 字符转换流 -- InputStreamReader
     * 目的地：
     * 		b.txt -- 写出数据 -- 字符转换流 -- OutputStreamWriter
     */

    @Test
    public void Test() throws IOException{
        // 封装数据源
        InputStreamReader isr = new InputStreamReader(new FileInputStream(
                "D:\\demo\\aa.txt"));
        // 封装目的地
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
                "D:\\demo\\bb.txt"));

        int by = 0;

        char[] bys = new char[1024];
        while ((by = isr.read(bys)) != -1) {
            System.out.println(new String(bys,0,by));
            osw.write(bys,0,by);
        }

        // 关闭资源
        osw.close();
        isr.close();
    }

    /**
     * 字符缓冲流特殊方法：
     * BufferedWriter:
     * 		public void newLine():根据系统决定换行符
     * BufferedReader:
     * 		public String readLine()：一次读取一行数据
     * 		包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null
     */

    @Test
    public void BufferedReaderDemo() throws IOException{
        // 创建字符缓冲输入流对象
        BufferedReader br = new BufferedReader(new FileReader("D:\\demo\\aa.txt"));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        //释放资源
        br.close();
    }

    @Test
    public void BufferedWriterDemo() throws IOException{
        // 创建字符缓冲输出流对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\demo\\aa.txt"));
        for (int i = 0; i < 10; i++) {
            bw.write("yang" + i);
            // bw.write("\r\n");
            bw.newLine(); // 根据系统决定换行符
            bw.flush();
        }
        bw.close();
    }
}





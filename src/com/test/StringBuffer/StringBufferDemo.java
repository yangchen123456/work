package com.test.StringBuffer;

import org.junit.Test;

/**
 * 线程安全
 * 安全 -- 同步 -- 数据是安全的
 * 不安全 -- 不同步 -- 效率高一些
 *
 *
 * StringBuffer:
 * 		线程安全的可变字符串。
 *
 * StringBuffer和String的区别?
 * 前者长度和内容可变，后者不可变。
 * 如果使用前者做字符串的拼接，不会浪费太多的资源。
 *
 * StringBuffer的构造方法：
 * 		public StringBuffer():无参构造方法
 *		public StringBuffer(int capacity):指定容量的字符串缓冲区对象
 *		public StringBuffer(String str):指定字符串内容的字符串缓冲区对象
 *
 * StringBuffer的方法：
 *		public int capacity()：返回当前容量。	理论值
 *		public int length():返回长度（字符数）。 实际值
 */
public class StringBufferDemo {
    /**
     * StringBuffer添加功能：
     * public StringBuffer append(String str):
     * 可以把任意类型数据添加到字符串缓冲区,并返回字符串缓冲区本身
     * <p>
     * public StringBuffer insert(int offset,String str):
     * 在指定位置把任意类型的数据插入到字符串缓冲区里面,并返回字符串缓冲区本身
     */
    public static void main(String[] args) {
        // 创建字符串缓冲区对象
        StringBuffer sb = new StringBuffer();

        // public StringBuffer append(String str)
        // StringBuffer sb2 = sb.append("hello");
        // System.out.println("sb:" + sb);
        // System.out.println("sb2:" + sb2);
        // System.out.println(sb == sb2); // true

        // 一步一步的添加数据
        // sb.append("hello");
        // sb.append(true);
        // sb.append(12);
        // sb.append(34.56);

        // 链式编程
        sb.append("yang").append("chen").append(2000).append(215);
        System.out.println("sb:" + sb);

        // public StringBuffer insert(int offset,String
        // str):在指定位置把任意类型的数据插入到字符串缓冲区里面,并返回字符串缓冲区本身
        sb.insert(5, "gong");
        System.out.println("sb:" + sb);
    }

    //添加功能

    /**
     * * StringBuffer添加功能：
     *  * public StringBuffer append(String str):
     *       可以把任意类型数据添加到字符串缓冲区,并返回字符串缓冲区本身
     *  *
     *  * public StringBuffer insert(int offset,String str):
     *       在指定位置把任意类型的数据插入到字符串缓冲区里面,并返回字符串缓冲区本身
     */
    @Test
    public void deleteStringBufferDemo() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("yang").append("chen").append(20);
        System.out.println("buffer:" + buffer);

        /**
         * 1.删除指定位置的字符---buffer.deleteCharAt(1)--删除a
         * 2.删除字符串chen-----buffer.delete(4,9)---删除字符串chen
         * 3.删除所有数据------ buffer.delete(0,buffer.lenght())
         */
        System.out.println("删除指定字符：" + buffer.deleteCharAt(1));

        System.out.println("删除字符串：" + buffer.delete(4, 9));

        System.out.println("删除全部：" + buffer.delete(0, buffer.length()));
    }

    //替换功能 replace()
    @Test
    public void replace() {
        // 创建字符串缓冲区对象
        StringBuffer sb = new StringBuffer();

        // 添加数据
        sb.append("yang");
        sb.append("chen");
        sb.append("hello");
        System.out.println("sb:" + sb);
        // public StringBuffer replace(int start,int end,String
        // str):从start开始到end用str替换
        // 需求：我要把world这个数据替换为"节日快乐"
        System.out.println(sb.replace(4, 8, "节日快乐"));
    }

    //反转功能 reverse()
    @Test
    public void reverse() {
        // 创建字符串缓冲区对象
        StringBuffer sb = new StringBuffer();

        // 添加数据
        sb.append("yang");
        sb.append("chen");
        sb.append("hello");
        System.out.println("sb:" + sb);
        System.out.println("反转数据：" + sb.reverse());
    }

    //截取功能 substring(int start)，substring(int start,int end)
    @Test
    public void substring() {

        /**
         * StringBuffer的截取功能:注意返回值类型不再是StringBuffer本身了
         * public String substring(int start)
         * public String substring(int start,int end)
         */
        // 创建字符串缓冲区对象
        StringBuffer sb = new StringBuffer();

        // 添加数据
        sb.append("yang");
        sb.append("chen");
        sb.append("hello");
        System.out.println("sb:" + sb);

        //截取数据
        String s = sb.substring(1);
        System.out.println("s:" + s);
        System.out.println("sb:" + sb);

        String ss = sb.substring(1, 4);
        System.out.println("ss:" + ss);
        System.out.println("sb:" + sb);
    }

    /**
     * 类之间的转化
     * A -- B的转换
     * 把A转换为B，其实是为了使用B的功能。
     *    B -- A的转换
     * 可能要的结果是A类型，所以还得转回来。
     *
     * String与StringBuffer的相互
     */
    @Test
    public void change(){
        // String -- StringBuffer
        String s = "yang";
        //主意：不能把字符串的值赋值给StringBuffer
        //方式一通过构造方法
        StringBuffer stringBuffer = new StringBuffer(s);
        //方式二 通过append() 方法
        StringBuffer buffer = new StringBuffer();
        buffer.append(s);
        System.out.println("stringBuffer:"+stringBuffer);
        System.out.println("buffer:"+buffer);
        System.out.println("---------------");

        //StringBuffer --- String
        StringBuffer buffer1 = new StringBuffer("yyyy");
        //方法一。通过String构造方法
        String s1 = new String(buffer1);

        //方法二，通过tostring()方法
        java.lang.String s2 = buffer1.toString();
        System.out.println("s1:"+s1);
        System.out.println("s2"+s2);
    }

    /**
     * 将数组拼接成字符串
     */
    @Test
    public void joint(){
        // 定义一个数组
        int[] arr = { 44, 33, 55, 11, 22 };

        // 定义功能
        // 方式1：用String做拼接的方式
        String s1 = arrayToString(arr);
        System.out.println("s1:" + s1);

        // 方式2:用StringBuffer做拼接的方式
        String s2 = arrayToString2(arr);
        System.out.println("s2:" + s2);
    }

    // 用StringBuffer做拼接的方式
    public String arrayToString(int[] arr){
        StringBuffer buffer = new StringBuffer();
        buffer.append("[");
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                buffer.append(arr[x]);
            } else {
                buffer.append(arr[x]).append(", ");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    // 用String做拼接的方式
    public String arrayToString2(int[] arr){
        String s = "";
        s += "[";
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                s += arr[x];
            } else {
                s += arr[x];
                s += ", ";
            }
        }
        s += "]";
        return s;
    }

    @Test
    public void test() {
        String s1 = "hello";
        String s2 = "world";
        System.out.println(s1 + "---" + s2);// yang---chen
        change(s1, s2);
        System.out.println(s1 + "---" + s2);// yang---chen

        StringBuffer sb1 = new StringBuffer("yang");
        StringBuffer sb2 = new StringBuffer("chen");
        System.out.println(sb1 + "---" + sb2);// yang---chen
        change(sb1, sb2);
        System.out.println(sb1 + "---" + sb2);// yang---chenchen

    }

    public void change(StringBuffer sb1, StringBuffer sb2) {
        sb1 = sb2;
        sb2.append(sb1);
    }

    public  void change(String s1, String s2) {
        s1 = s2;
        s2 = s1 + s2;
    }
}

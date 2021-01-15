package com.bh.ArrayList;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

public class ArrayListDemo {
    /**
     * List特点：
     * ArrayList:
     * 底层数据结构是数组，查询快，增删慢
     * 线程不安全，效率高
     * Vector:
     * 底层数据结构是数组，查询快，增删慢
     * 线程安全，效率低
     * LinkedList:
     * 底层数据结构是链表，查询慢，增删快
     * 线程不安全，效率高
     * <p>
     * 案例：
     * 使用List的任何子类存储字符串或者存储自定义对象并遍历。
     * <p>
     * ArrayList的使用。
     * 存储字符串并遍历
     */
    @Test
    public void Test() {
        ArrayList<String> list = new ArrayList<>();

        list.add("yang");
        list.add("gong");
        list.add("chen");
        System.out.println(list);

        // 迭代器遍历
        Iterator<String> iterator = list.iterator();
        System.out.println("迭代器遍历=========");

        while (iterator.hasNext()) {
            String s = (String) iterator.next();
            System.out.println(s);
        }
        System.out.println("for循环遍历=========");
        // for循环遍历
        for (int i = 0; i < list.size(); i++) {
            String ss = list.get(i);
            System.out.println(ss);
        }
    }

    /**
     * Vector的特有功能：
     * 1：添加功能
     * public void addElement(Object obj)		--	add()
     * 2：获取功能
     * public Object elementAt(int index)		--  get()
     * public Enumeration elements()			--	Iterator iterator()
     * boolean hasMoreElements()				hasNext()
     * Object nextElement()					next()
     * <p>
     * JDK升级的原因：
     * A:安全
     * B:效率
     * C:简化书写
     */

    @Test
    public void VectorTest() {
        // 创建集合对象
        Vector v = new Vector();

        // 添加功能
        v.addElement("yang");
        v.addElement("gong");
        v.addElement("chen");

        // 遍历
        for (int i = 0; i < v.size(); i++) {
            String s = (String) v.elementAt(i);
            System.out.println(s);
        }

        System.out.println("------------------");

        Enumeration en = v.elements(); // 返回的是实现类的对象
        while (en.hasMoreElements()) {
            String s = (String) en.nextElement();
            System.out.println(s);
        }
    }

    /**
     * LinkedList的特有功能：
     * A:添加功能
     * public void addFirst(Object e)
     * public void addLast(Object e)
     * B:获取功能
     * public Object getFirst()
     * public Obejct getLast()
     * C:删除功能
     * public Object removeFirst()
     * public Object removeLast()
     */

    @Test
    public void LinkedListTest() {
        LinkedList<String> list = new LinkedList<>();

        list.add("yang");
        list.add("gong");
        list.addLast("hello");
        list.add("chen");

        // 迭代器
        Iterator<String> iterator = list.iterator();
        System.out.println("LinkedList迭代器遍历=========");
        while (iterator.hasNext()) {
            String next = (String) iterator.next();
            System.out.println(next);
        }

        System.out.println("for循环遍历==============");
        // for循环遍历
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }

    /**
     * /*
     * * 获取10个1-20之间的随机数，要求不重复
     * *
     * * 用数组实现，但是数组的长度是固定，所以用集合实现。
     * *
     * * 分析：
     * * 		A:创建产生随机数的对象
     * * 		B:创建一个存储随机数的集合。
     * * 		C:定义一个统计变量。从0开始。
     * * 		D:判断统计遍历是否小于10
     * * 			是:先产生一个随机数，判断该随机数在集合中是否存在。
     * * 					如果不存在:就添加，统计变量++。
     * * 					如果存在:
     * * 			否：不搭理它
     * * 		E:遍历集合
     */
    @Test
    public void Test2() {
        Random r = new Random();

        ArrayList<Integer> list = new ArrayList<Integer>();

        int count = 0;// 定义一个统计变量。从0开始。
        while (count < 10) {
            int i = r.nextInt(20) + 1;
            if (!list.contains(i)) {
                list.add(i);
                count++;
            }
        }
        System.out.println(list);
        // 循环遍历
        System.out.println("循环遍历==========");
        for (int i = 0; i < list.size(); i++) {
            Integer s = list.get(i);
            System.out.println(s);
        }
    }

    /**
     * 键盘录入多个数据，以0结束，要求在控制台输出这多个数据中的最大值
     *
     * 分析：
     * 		A:创建键盘录入数据对象
     * 		B:键盘录入多个数据,不确定数量，所以用集合存储
     * 		C:以0结束,这个简单，只要键盘录入的数据是0，停止录入
     * 		D:把集合转成数组
     * 		E:对数组排序
     * 		F:获取该数组中的最大索引的值
     */
    public static void main(String[] args) {
        System.out.println("请输入数据：");
        // 创建键盘录入对象
        Scanner scanner = new Scanner(System.in);
        // 创建集合
        ArrayList<Integer> ss = new ArrayList<Integer>();

        // 循环
        while (true){
            int i = scanner.nextInt();
            if (i != 0){
                ss.add(i);
            }else {
                break;
            }
        }
        // 创建数组
        Integer[] sz = new Integer[ss.size()];

        //结合转化为数组
        ss.toArray(sz);

        //对数组进行排序
        Arrays.sort(sz);

        // 循环
        for (int i = 0; i <sz.length; i++) {
            System.out.print(sz[i]+",");
        }
        // 获取该数组中的最大索引的值
        System.out.println("最大值是:" + sz[sz.length - 1]);



    }
    // 数组转为字符串
//    public static String arrayToString(Integer[] sz) {
//        StringBuilder sb = new StringBuilder(); // 字符串缓冲区
//
//        sb.append("[");
//        for (int x = 0; x < sz.length; x++) {
//            if (x == sz.length - 1) {
//                sb.append(sz[x]);
//            } else {
//                sb.append(sz[x]).append(", ");
//            }
//        }
//        sb.append("]");
//
//        return sb.toString(); // 字符串
//    }
}

package com.bh.Map;

import org.junit.Test;

import java.util.*;

public class MapDemo {
    /**
     * Map特点：
     * Map 集合类用于存储元素对（称作“键”和“值”），其中每个键映射到一个值。
     * Map功能：
     * 1.添加功能：添加一个键和值---map.put(key,value);
     *      将一个map添加到另一个map中-----map.putAll()
     * 2.获取功能：根据指定的key获取对应的value----map.get("key");
     * 3.删除功能：根据key值删除对应的值-----------map.remove("key");
     * 4.清空功能：从这个映射中移除所有的映射（可选操作）--clea()
     * 4.判断功能：判断map是否为空----------------map.isEmpty()返回为布尔类型true/false
     * 5.获取长度：map.size()
     * 6.判断是否含有指定的key-------------------map.containsKey("key")
     * 7.判断是否含有指定的value-----------------map.containsValue("value")
     * 8.替换功能： replace("key","value")
     *      replaceAll() 方法将 hashMap 中的所有映射关系替换成给定的函数所执行的结果。
     * 9.获取所有value ----map.values()
     */

    public static void main(String[] args) {
        //创建Map对象
        Map<String, String> map = new HashMap<String, String>();
        Map<String, String> map1 = new HashMap<String, String>();
        //给map中添加元素
        map.put("name", "杨公辰");
        map.put("address", "济南");

        map1.put("age", "12aa");
        map1.put("sex", "男aa");
        // putAll()
        map.putAll(map1);
        System.out.println(map);// {address=济南, sex=男, name=杨公辰, age=12}

        //当给Map中添加元素，会返回key对应的原来的value值，若key没有对应的值，返回null
        System.out.println("添加元素=============");
        System.out.println(map.put("name", "jack")); // 杨公辰
        System.out.println(map); // {address=济南, sex=男, name=jack, age=12}
//        System.out.println(map.put("ss","ss")); // null

        //根据指定的key获取对应的value
        System.out.println("根据key获取value=============");
        String uname = map.get("name");
        System.out.println(uname); // jack

        //根据key删除元素,会返回key对应的value值
//        System.out.println("根据key删除元素=========");
//        String value = map.remove("name");
//        System.out.println(value); // jack
//        System.out.println(map); // {address=济南}

//        // 清空clear()
//        map.clear();
//        System.out.println(map); // 为空

        // 获取长度
        System.out.println(map.size()); //2

        // 判断map是否有内容
        System.out.println(map.isEmpty());// false

        // 判断是否含有key
        System.out.println(map.containsKey("name"));// true

        // 判断是否含有value
        System.out.println(map.containsValue("济南"));

        // 替换
        map.replace("name","张三");
        System.out.println(map);

        //replaceAll() 方法将 hashMap 中的所有映射关系替换成给定的函数所执行的结果。
        map1.replaceAll((key, value) -> value.toUpperCase());
        System.out.println(map1);

        //获取map所有的值
        Collection<String> values = map.values();
        System.out.println(values);


    }

    /**
     * 遍历
     */
    @Test
    public void MapTest(){
        //创建Map对象
        Map<String, String> map = new HashMap<String, String>();
        //给map中添加元素
        map.put("name", "杨公辰");
        map.put("address", "济南");

        //获取Map中的所有key
        Set<String> keySet = map.keySet();
        //遍历存放所有key的Set集合

        // 利用迭代器遍历key然后利用get(key)来获取key的值
        Iterator<String> it =keySet.iterator();
        while(it.hasNext()){
            //循环遍历得到每一个key
            String key = it.next();
            //通过key获取对应的value
            String value = map.get(key);
            System.out.println(key+"="+value);
        }

        // for循环
        for (String s:keySet){
            //通过key获取对应的value
            String value = map.get(s);
            System.out.println(s+"="+value);
        }
    }

}

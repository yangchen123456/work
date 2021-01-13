package com.test.String;

public class Demo09 {
    /**
     * 需求：把数组中的数据按照指定个格式拼接成一个字符串
     * 举例：
     * 		int[] arr = {1,2,3};
     * 输出结果：
     *		"[1, 2, 3]"
     * 分析：
     * 		A:定义一个字符串对象，只不过内容为空
     * 		B:先把字符串拼接一个"["
     * 		C:遍历int数组，得到每一个元素
     * 		D:先判断该元素是否为最后一个
     * 			是：就直接拼接元素和"]"
     * 			不是：就拼接元素和逗号以及空格
     * 		E:输出拼接后的字符串
     * 把代码用功能实现。
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        String s = "";
        s += "[";
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length-1) {      // 判断该元素是否为最后一个
                s += arr[i];
                s += "]";
            }else {
                s += arr[i];
                s += ",";
            }
        }
        System.out.println("结果: " +s);
    }
}

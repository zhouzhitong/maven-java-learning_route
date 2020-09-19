package com.zzt.data_structures.operator;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>异或运算： ^
 * 特点：无进位相加
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/19 14:23
 **/
public class XorOperatorDemo {

    public static void main(String[] args) {
        // 6 : 110
        // 7 : 111
        //   : 001 = 1
        int i = 6 ^ 7;
        System.out.println(i);

        int a = 6, b = 7;
        System.out.println("交换前：" + a + " -- " + b);
        // a 和 b 值进行交换
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        // 第二种交换
//        a = a + b;
//        b = a - b;
//        a = a - b;

        System.out.println("交换后：" + a + " -- " + b);

    }

    // 取出 集合中的 唯一存在奇数个的数值。
    @Test
    public void test02() {
        // 唯一 ： 3
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 4, 4};
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            temp ^= arr[i];
        }
        System.out.println(temp);
    }

    // 取出 集合中的 存在 2个 奇数个的数值。
    @Test
    public void test03() {
        // 唯一 ： 3 ,4
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5};
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            temp ^= arr[i];
        }
        int a = temp & (~temp + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((a & arr[i]) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne);
        System.out.println(temp ^ onlyOne);
    }

}

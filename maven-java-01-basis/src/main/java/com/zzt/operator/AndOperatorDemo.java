package com.zzt.operator;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>与运算： &
 * 特点：相同为1，不同为0
 * <p>
 * </>
 * 使用案例：
 * 1. 求一个数字的最右侧的 1（二进制的 1 ）
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/19 15:01
 **/
public class AndOperatorDemo {

    public static void main(String[] args) {
        // 6 : 110
        // 5 : 101
        //   : 010 = 2
        int a = 7 & (~7 + 1);
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(-1));// 补码
        System.out.println(Integer.toBinaryString(-6));
        System.out.println(a);

        System.out.println((5 & 4));
    }

    // 判断任意数字中的 （二进制）1的个数
    @Test
    public void test01() {
        int a = 8, temp, count = 0;

        while (a > 0) {
            count++;
            temp = a & (~a + 1);
            a -= temp;
        }
        System.out.println(count);
    }

}

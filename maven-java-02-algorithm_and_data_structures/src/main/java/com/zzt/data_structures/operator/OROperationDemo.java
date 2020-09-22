package com.zzt.data_structures.operator;

/**
 * 描述：<br> 或运算符： |
 * 特点： 除了两个都是 0 的位置 为 0 外，其他情况都为 1
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/22 9:29
 **/
public class OROperationDemo {

    public static void main(String[] args) {
        // 9 : 1001     6 ：110
        // 1 : 0001     1 ：001
        //   ：1001 -> 9  ：111  -> 7
//        int i = 6 | 1;
        int i = 1 << 1 | 1;
        System.out.println(i);
    }

}

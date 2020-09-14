package com.zzt.algorithm.leet_code.day_20_09_14;

/**
 * 描述：<br> 7. 整数反转
 * 网址：https://leetcode-cn.com/problems/reverse-integer/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/14 18:06
 */
public class Solution02 {
    public int reverse(int x) {
        long reverse = 0;
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return (int) reverse == reverse ? (int) reverse : 0;
    }

    public static void main(String[] args) {
        int x = -123;
        System.out.println(new Solution02().reverse(x));
    }
}

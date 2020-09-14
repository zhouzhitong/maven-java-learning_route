package com.zzt.algorithm.leet_code.day_20_08_15;

/**
 * 描述：<br> 50. Pow(x,n) 即计算x 的 n 次幂函数
 * 网址：https://leetcode-cn.com/problems/powx-n/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/15 17:14
 */
public class Solution01 {

    public double myPow(double x, int n) {
        int temp_n = n;
        double ans = 1;
        while (n != 0) {
            if ((n & 1) != 0) {//和1与取末尾
                ans *= x;
            }
            x *= x;
            n /= 2;//相当于数字右移，每次取新的位做末位
        }
        return temp_n >= 0 ? ans : 1 / ans;
    }

    public static void main(String[] args) {
        double x = 2.1;
        int n = 3;
        System.out.println(new Solution01().myPow(x, n));
        System.out.println(Double.doubleToLongBits(x));
    }

}

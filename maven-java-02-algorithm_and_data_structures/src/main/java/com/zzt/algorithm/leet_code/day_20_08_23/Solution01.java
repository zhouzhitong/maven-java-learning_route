package com.zzt.algorithm.leet_code.day_20_08_23;

/**
 * 描述：<br>题库 -- 算法 --【每日一题】201. 数字范围按位与
 * 网址：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * </>
 * <p>个人思路：
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/23 10:39
 **/
public class Solution01 {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        if (m == 0) {
            return 0;
        }

        char[] cm = Integer.toBinaryString(m).toCharArray();
        char[] cn = Integer.toBinaryString(n).toCharArray();
        int len_n = cn.length;
        if (cm.length != len_n) {
            return 0;
        }

        int count = 0;
        while (true) {
            count++;
            if (cm[count] != cn[count]) {
                break;
            }
        }

        while (count < len_n) {
            cm[count] = '0';
            count++;
        }
        return Integer.valueOf(new String(cm), 2);
    }

    public int rangeBitwiseAnd2(int m, int n) {
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }

    public static void main(String[] args) {
        int m = 5, n = 7;
        System.out.println(new Solution01().rangeBitwiseAnd(m, n));
    }

}

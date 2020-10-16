package com.zzt.algorithm.leet_code_3;

/**
 * 描述：<br>231. 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/16 21:58
 **/
public class Solution_231 {

    public boolean isPowerOfTwo(int n) {
        int t = n;
        while (n > 0) {
            t ^= 1;
            if (t == 0) {
                return true;
            } else if (t > n) {
                t >>= 1;
                n = t;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(1 | 1);
//        System.out.println(9 ^ 1);
//        System.out.println(1 & 1);
        boolean powerOfTwo = new Solution_231().isPowerOfTwo(2 << 10);
        System.out.println(powerOfTwo);
    }

}

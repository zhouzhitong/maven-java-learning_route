package com.zzt.leet_code_9;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>941. 有效的山脉数组
 * https://leetcode-cn.com/problems/valid-mountain-array/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/3 9:58
 */
public class Solution_941 {


    public boolean validMountainArray(int[] a) {
        if (a.length < 3) {
            return false;
        }
        int pre = 0;
        int index = 1;
        while (index < a.length && a[pre] < a[index]) {
            pre++;
            index++;
        }
        if (index == 1 || index == a.length) {
            return false;
        }
        while (index < a.length && a[pre] > a[index]) {
            pre++;
            index++;
        }
        return a.length == index;
    }

    @Test
    public void test01() {
//        int[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] a = {14, 82, 89, 84, 79, 70, 70, 68, 67, 66, 63, 60, 58, 54, 44, 43, 32, 28, 26, 25, 22, 15, 13, 12, 10, 8, 7, 5, 4, 3};
        boolean b = new Solution_941().validMountainArray(a);
        System.out.println(b);
    }

}

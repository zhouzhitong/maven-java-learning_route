package com.zzt.leet_code_6;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>605. 种花问题
 * https://leetcode-cn.com/problems/can-place-flowers/
 * </>
 *
 * @author zzt
 */
public class Solution_605 {

    @Test
    public void test01() {
        int[] flowerbed = {0, 0, 1, 0, 1, 0};
        int n = 2;
        boolean b = canPlaceFlowers(flowerbed, n);
        System.out.println(b);
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int help = 0;
        int count = 1;
        for (int i : flowerbed) {
            if (i == 0) {
                count++;
            } else {
                help += (count - 1) / 2;
                count = 0;
            }
        }
        help += (count / 2);
        if (help >= n) {
            return true;
        } else {
            return false;
        }
    }

}

package com.zzt.leet_code_13;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 描述：<br>1356. 根据数字二进制下 1 的数目排序
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/6 10:24
 */
public class Solution_1356 {

    public int[] sortByBits(int[] arr) {
        int length = arr.length;
        /* 根据 1的个数 和 当前数值，存储 每一个数字：
           此处是本题解的精髓：1的个数权值最大，其次是本身的值，方便之后的 还原和排序 */
        for (int i = 0; i < length; i++) {
            arr[i] = bitCount(arr[i]) * 100_000 + arr[i];
        }
        /* 将 存储的数字，还原成最初始的数字，并根据 1的个数 和 当前数值 排序 */
        Arrays.sort(arr);
        for (int i = 0; i < length; i++) {
            arr[i] %= 100_000;
        }
        return arr;
    }

    private int bitCount(int a) {
        int count = 0;
        while (a > 0) {
            if (a > (a ^ 1)) {
                count++;
            }
            a >>= 1;
        }
        return count;
    }

    @Test
    public void test02() {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] ints = new Solution_1356().sortByBits(arr);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test01() {
        int a = 11; // 1011
        int b = a ^ 1;
        System.out.println(b);
    }
}

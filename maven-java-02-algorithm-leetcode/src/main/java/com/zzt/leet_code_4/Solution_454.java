package com.zzt.leet_code_4;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：<br>493. 翻转对
 * https://leetcode-cn.com/problems/reverse-pairs/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/27 23:37
 **/
public class Solution_454 {

    @Test
    public void test01() {
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};

        int i = new Solution_454().fourSumCount(A, B, C, D);
        System.out.println(i);

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int len = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = C[i] + D[j];
                res += map.getOrDefault(-1 * sum, 0);
            }
        }
        return res;
    }

}

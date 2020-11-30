package com.zzt.leet_code_9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 描述：<br> 976. 三角形的最大周长
 * https://leetcode-cn.com/problems/largest-perimeter-triangle/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/29 21:31
 **/
public class Solution_976 {

    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int endFirstIndex = A.length - 1;
        int endSecondIndex = endFirstIndex - 1;
        int endThirdIndex = endSecondIndex - 1;

        while (endThirdIndex != -1) {
            if (A[endThirdIndex] + A[endSecondIndex] > A[endFirstIndex]) {
                return A[endThirdIndex] + A[endSecondIndex] + A[endFirstIndex];
            } else {
                endFirstIndex--;
                endSecondIndex = endFirstIndex - 1;
                endThirdIndex = endSecondIndex - 1;
            }
        }
        return 0;
    }

    @Test
    public void test01() {
        int[] A = {3, 6, 2, 3};
        int i = new Solution_976().largestPerimeter(A);
        System.out.println(i);
    }

}

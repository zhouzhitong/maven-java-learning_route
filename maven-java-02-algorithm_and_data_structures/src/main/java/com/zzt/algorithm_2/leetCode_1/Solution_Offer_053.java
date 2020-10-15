package com.zzt.algorithm_2.leetCode_1;

/**
 * 描述：<br>
 * https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 10:49
 */
public class Solution_Offer_053 {

    public int missingNumber(int[] nums) {
        int t = 0;
        for (int num : nums) {
            if (num != t) {
                break;
            }
            t++;
        }
        return t;
    }


}

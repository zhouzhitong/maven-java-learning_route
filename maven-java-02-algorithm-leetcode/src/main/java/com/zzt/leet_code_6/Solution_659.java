package com.zzt.leet_code_6;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>659. 分割数组为连续子序列
 * https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/12/4 16:38
 */
public class Solution_659 {

    @Test
    public void test01() {
        int[] nums = {1, 2, 3, 3, 4, 5};
        System.out.println(isPossible(nums));
    }

    public boolean isPossible(int[] nums) {
        // 基于贪心算法
        //第一个哈希表，存储每个数字出现次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        //以当前数字作为结尾的子序列的数量
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if (count > 0) {
                //以x - 1为结尾的子序列的个数
                int prevEndCount = endMap.getOrDefault(x - 1, 0);
                //如果以 x - 1 为结尾的子序列个数 > 0
                if (prevEndCount > 0) {
                    //将x 加入该子序列， 同时 x 个数 - 1
                    countMap.put(x, count - 1);
                    //以x - 1结尾的子序列加了一个 x 变为以 x 结尾的子序列
                    //故 x - 1结尾子序列个数 - 1
                    endMap.put(x - 1, prevEndCount - 1);
                    //x 结尾子序列个数 + 1
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {//获得以 x 为起始，长度至少为 3 的子序列
                    // x + 1 个数
                    int count1 = countMap.getOrDefault(x + 1, 0);
                    //x + 2 个数
                    int count2 = countMap.getOrDefault(x + 2, 0);
                    //个数大于0， 相应个数减一
                    if (count1 > 0 && count2 > 0) {
                        countMap.put(x, count - 1);
                        countMap.put(x + 1, count1 - 1);
                        countMap.put(x + 2, count2 - 1);
                        //以 x + 2 结尾子序列个数 + 1
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

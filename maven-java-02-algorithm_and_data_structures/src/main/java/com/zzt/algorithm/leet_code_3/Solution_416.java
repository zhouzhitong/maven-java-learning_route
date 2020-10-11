package com.zzt.algorithm.leet_code_3;

import java.util.Arrays;

/**
 * 描述：<br> 416. 分割等和自己
 * 网址：https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * </>
 *
 * @author 周志通
 * @date 2020/10/11 14:16
 **/
public class Solution_416 {

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int partition;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        partition = sum / 2;
        if (nums[nums.length - 1] > partition) {
            return false;
        } else if (nums[nums.length - 1] == partition) {
            return true;
        }
        partition = partition - nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= partition) {
                int copy = partition;
                copy -= nums[i];
                if (copy == 0) {
                    return true;
                }
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] <= copy) {
                        copy -= nums[j];
                        if (copy == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }

}

package com.zzt.algorithm.leet_code_3;

import java.util.Arrays;

/**
 * 描述：<br> 416. 分割等和子集
 * 网址：https://leetcode-cn.com/problems/partition-equal-subset-sum/
 * </>
 *
 * @author 周志通
 * @date 2020/10/11 14:16
 **/
public class Solution_416 {
    private int[] nums;

    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        int sum = 0;
        int partition;
        for (int num : nums) {
            sum += num;
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
//        partition = partition - nums[nums.length - 1];
        return dfs(partition, nums.length - 1);
    }

    private boolean dfs(int partition, int i) {
        if (partition == 0) {
            return true;
        } else if (partition < 0) {
            return false;
        }
        for (int j = i; j >= 0; j--) {
            boolean dfs = dfs(partition - this.nums[j], j - 1);
            if (dfs) {
                return true;
            }
        }
        return false;
    }

    /*public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int partition;
        for (int num : nums) {
            sum += num;
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
    }*/

    public static void main(String[] args) {
//        int[] nums = {1, 5, 11, 5};
        int[] nums = {100, 100, 100, 100, 100, 100, 99, 97};
        boolean b = new Solution_416().canPartition(nums);
        System.out.println(b);
    }

}

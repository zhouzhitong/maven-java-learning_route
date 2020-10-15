package com.zzt.algorithm.leet_code_2;

import java.util.*;

/**
 * 描述：<br>46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/15 11:26
 */
public class Solution_046 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        process(result,new ArrayList<>(),nums,new HashSet<>());
        return result;
    }

    private void process(List<List<Integer>> result, List<Integer> list, int[] nums, Set<Integer> set) {
        if (set.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            if (set.contains(t)) {
                continue;
            }
            list.add(t);
            set.add(t);
            process(result, list, nums, set);
            list.remove(list.size()-1);
            set.remove(t);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        List<List<Integer>> permute = new Solution_046().permute(nums);
        permute.forEach(System.out::println);
    }

}

package com.zzt.algorithm.leet_code_3;

import java.util.*;

/**
 * 描述：<br> 229. 求众数 II
 *     网址：https://leetcode-cn.com/problems/majority-element-ii/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/10 11:47
 */
public class Solution_229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 定义两个候选者和它们的票数
        int cand1 = 0, cand2 = 0;
        int cnt1 = 0, cnt2 = 0;
        // 投票过程
        for (int num : nums) {
            // 如果是候选者1，票数++
            if (num == cand1) {
                cnt1++;
                // 一遍遍历，如果你不想写continue，你写多个else if也可以
                continue;
            }
            // 如果是候选者2，票数++
            if (num == cand2) {
                cnt2++;
                continue;
            }
            // 既不是cand1也不是cand2，如果cnt1为0，那它就去做cand1
            if (cnt1 == 0) {
                cand1 = num;
                cnt1++;
                continue;
            }
            // 如果cand1的数量不为0但是cand2的数量为0，那他就去做cand2
            if (cnt2 == 0) {
                cand2 = num;
                cnt2++;
                continue;
            }
            // 如果cand1和cand2的数量都不为0，那就都-1
            cnt1--;
            cnt2--;
        }
        // 检查两个票数符不符合
        cnt1 = cnt2 = 0;
        for (int num : nums) {
            if (num == cand1) {
                cnt1++;
            } else if (num == cand2) {
                // 这里一定要用else if
                // 因为可能出现[0,0,0]这种用例，导致两个cand是一样的，写两个if结果就变为[0,0]了
                cnt2++;
            }
        }
        int n = nums.length;
        if (cnt1 > n / 3) {
            res.add(cand1);
        }
        if (cnt2 > n / 3) {
            res.add(cand2);
        }
        return res;
    }

    /*public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer t;
        for (int num : nums) {
            t = map.get(num);
            map.put(num, t == null ? 1 : ++t);
        }
        List<Integer> list = new ArrayList<>();
        int finalMaxCount = nums.length / 3;
        map.forEach((k, v) -> {
            if (finalMaxCount < v) {
                list.add(k);
            }
        });
        return list;
    }*/

    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 1, 3, 3, 3};
        List<Integer> list = new Solution_229().majorityElement(nums);
        System.out.println(list);
    }

}

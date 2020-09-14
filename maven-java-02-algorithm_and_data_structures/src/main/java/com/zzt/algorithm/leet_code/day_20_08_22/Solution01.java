package com.zzt.algorithm.leet_code.day_20_08_22;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：<br> 题库 -- 算法 --【每日一题】679. 24点游戏
 * 个人网址：https://leetcode-cn.com/problems/24-game/
 * </>
 * <p>个人思路：
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/22 22:08
 **/
public class Solution01 {

    public boolean judgePoint24(int[] nums) {
        return compose_of_two(nums);
    }

    private boolean compose_of_two(int[] nums) {
        Set<Integer> integers;
        int len = nums.length, count1, count2;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                integers = new HashSet<>();
                count1 = 0;
                addSetData(nums, i, j, integers);
                while (count1 < 4) {
                    if (count1 == i || count1 == j) {
                        count1++;
                    } else {
                        break;
                    }
                }
                count2 = count1 + 1;
                while (count2 < 4) {
                    if (count2 == i || count2 == j || count2 == count1) {
                        count2++;
                    } else {
                        break;
                    }
                }
                System.out.println("结果集：" + Arrays.toString(integers.toArray()));
                System.out.println(i + " -- " + j + " --> " + count1 + " -- " + count2);
                if (integers.contains(nums[count1] + nums[count2])) {
                    System.out.println(nums[count1] + nums[count2]);
                    return true;
                }
                if (integers.contains(nums[count1] - nums[count2])) {
                    System.out.println(nums[count1] - nums[count2]);
                    return true;
                }
                if (integers.contains(nums[count1] * nums[count2])) {
                    System.out.println(nums[count1] * nums[count2]);
                    return true;
                }
                if (integers.contains(nums[count1] / nums[count2])) {
                    System.out.println(nums[count1] / nums[count2]);
                    return true;
                }
                if (integers.contains(nums[count2] - nums[count1])) {
                    System.out.println(nums[count2] - nums[count1]);
                    return true;
                }
                if (integers.contains(nums[count2] / nums[count1])) {
                    System.out.println(nums[count2] / nums[count1]);
                    return true;
                }
            }
        }
        return compose_of_three(nums);
    }

    private void addSetData(int[] nums, int i, int j, Set<Integer> integers) {
        integers.add(24 + nums[i] + nums[j]);
        integers.add(24 - nums[i] + nums[j]);
        integers.add(24 / (nums[i] + nums[j]));
        integers.add(24 * (nums[i] + nums[j]));
        System.out.println("结果集：" + Arrays.toString(integers.toArray()));

        integers.add(24 + nums[i] - nums[j]);
        integers.add(24 - nums[i] - nums[j]);
        integers.add((nums[i] - nums[j]) > 0 ? 24 / (nums[i] - nums[j]) : 24);
        integers.add(24 * (nums[i] - nums[j]));
        System.out.println("结果集：" + Arrays.toString(integers.toArray()));

        integers.add(24 + nums[i] * nums[j]);
        integers.add(24 - nums[i] * nums[j]);
        integers.add(24 / (nums[i] * nums[j]));
        integers.add(24 * (nums[i] * nums[j]));

        integers.add(24 + nums[i] / nums[j]);
        integers.add(24 - nums[i] / nums[j]);
        integers.add((int) (24 / (double) (nums[i] / nums[j])));
        integers.add((int) (24 * (double) (nums[i] / nums[j])));

        integers.add(24 + nums[j] - nums[i]);
        integers.add(24 - nums[j] - nums[i]);
        integers.add((nums[j] - nums[i]) > 0 ? 24 / (nums[j] - nums[i]) : 24);
        integers.add(24 * (nums[j] - nums[i]));

        integers.add(24 + nums[j] / nums[i]);
        integers.add(24 - nums[j] / nums[i]);
        integers.add((int) (24 / (double) (nums[j] / nums[i])));
        integers.add((int) (24 * (double) (nums[j] / nums[i])));
    }


    /*private int calculation(int num1, int num2, char c) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return 0;
    }*/


    private boolean compose_of_three(int[] nums) {
        return false;
    }

    public static void main(String[] args) {
//        int a = 1, b = 4, c = 7;
//        double d = (double) a / b;
//        int e = (int) (c / d);
//        System.out.println(d + " -- " + e);
//        int[] num = {4, 1, 8, 7};
//        int[] num = {2, 3, 3, 3};
        int[] num = {1, 1, 1, 1};
        System.out.println(new Solution01().judgePoint24(num));
    }

}

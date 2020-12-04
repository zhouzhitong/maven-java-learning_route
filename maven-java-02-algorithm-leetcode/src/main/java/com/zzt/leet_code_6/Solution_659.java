package com.zzt.leet_code_6;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/12/4 16:38
 */
public class Solution_659 {

    @Test
    public void test01() {
        int[] nums = {1, 2, 3, 3, 4, 5, 5, 6, 6, 7, 8};
        System.out.println(isPossible(nums));
    }

    public boolean isPossible(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (stack.peek() != num) {
                stack.push(num);
            }
        }

        int num = stack.pop();        // 当前指针指向的数值
        int preCount = map.get(num);  // 前一个数值的数量
        int len = 0;                // 已经读取的长度
        Stack<Integer> help = new Stack<>();
        int curCount;               // 当前指针的数值的数量
        int curNum;
        while ((curNum = stack.pop()) != 0) {
            curCount = map.get(curNum);

            if (curCount < preCount) {
                return false;
            } else {
                len++;
            }


        }

        System.out.println(stack);
        System.out.println(map);

        return false;
    }
}

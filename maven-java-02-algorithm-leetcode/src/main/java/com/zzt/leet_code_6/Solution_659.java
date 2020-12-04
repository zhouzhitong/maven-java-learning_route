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

        int i;
        while ((i = stack.pop()) != 0) {
            Integer num = map.get(i);

        }

        System.out.println(stack);
        System.out.println(map);

        return false;
    }
}

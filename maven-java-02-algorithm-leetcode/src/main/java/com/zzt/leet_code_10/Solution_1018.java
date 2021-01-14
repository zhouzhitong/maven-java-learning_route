package com.zzt.leet_code_10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 描述：<br>1046. 最后一块石头的重量
 * https://leetcode-cn.com/problems/last-stone-weight/
 * </>
 *
 * @author zzt
 */
public class Solution_1018 {

    @Test
    public void test01() {
        int[] stones = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        List<Boolean> booleans = prefixesDivBy5(stones);
        System.out.println(booleans);
    }

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>(A.length);
        int tail = 0;
        for (int a : A) {
            tail = (tail << 1) + a;
            tail = (tail > 9) ? tail - 10 : tail;
            res.add(tail == 0 || tail == 5);
        }
        return res;
    }

}

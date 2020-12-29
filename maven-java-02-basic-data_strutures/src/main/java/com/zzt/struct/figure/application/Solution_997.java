package com.zzt.struct.figure.application;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 描述：<br>997. 找到小镇的法官
 https://leetcode-cn.com/problems/find-the-town-judge/
 </>
 @author zzt */
public class Solution_997 {

    @Test
    public void test01() {
        int N = 3;
//        int[][] trust = {{1, 8}, {1, 3}, {2, 8}, {2, 3}, {4, 8}, {4, 3}, {5, 8}, {5, 3}, {6, 8}, {6, 3}, {7, 8}, {7, 3}, {9, 8}, {9, 3}, {11, 8}, {11, 3}};
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        int judge = findJudge(N, trust);
        System.out.println(judge);
    }

    public int findJudge(int N, int[][] trust) {
        if (trust.length == 0) {
            if (N == 1) {
                return 1;
            } else {
                return -1;
            }
        }
        int count = N - 1;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] ints : trust) {
            Integer a = ints[0];
            Integer b = ints[1];
            set.add(a);
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        for (Integer in : map.keySet()) {
            if (set.contains(in)) continue;
            if (map.get(in) == count) return in;
        }
        return -1;
    }
}

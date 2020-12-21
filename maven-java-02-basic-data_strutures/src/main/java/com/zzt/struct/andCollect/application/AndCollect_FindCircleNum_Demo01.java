package com.zzt.struct.andCollect.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>547. 朋友圈
 * https://leetcode-cn.com/problems/friend-circles/
 * </>
 *
 * @author zzt
 */
public class AndCollect_FindCircleNum_Demo01 {

    @Test
    public void test01() {
        int[][] m = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = findCircleNum(m);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] M) {
        AndCollect collect = new AndCollect();
        collect.init(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    collect.union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M.length; i++) {
            Integer father = collect.findFather(i);
            set.add(father);
        }
        return set.size();
    }

    private static class AndCollect {

        private Map<Integer, Integer> parentMap;

        public AndCollect() {
            parentMap = new HashMap<>();
        }

        public void init(int n) {
            for (int i = 0; i < n; i++) {
                parentMap.put(i, i);
            }
        }

        public Integer findFather(int child) {
            Stack<Integer> stack = new Stack<>();
            int help;
            while ((help = parentMap.get(child)) != child) {
                stack.push(help);
                child = help;
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), help);
            }
            return help;
        }

        public void union(int a, int b) {
            Integer parA = findFather(a);
            Integer parB = findFather(b);
            if (!parA.equals(parB)) {
                parentMap.put(parA, parB);
            }
        }

    }

}

package com.zzt.struct.figure.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>207. 课程表（未通过测试）
 * https://leetcode-cn.com/problems/course-schedule/
 * </>
 *
 * @author zzt
 */
public class Solution_207 {

    @Test
    public void test01() {
        int numCourses = 3;
        int[][] prerequisites = {{1, 2}, {0, 2}, {0, 1}};
        boolean b = canFinish(numCourses, prerequisites);
        System.out.println(b);
    }

    Map<Integer, Integer> parent;
    Map<Integer, Integer> sizeMap;
    Set<Integer> exitsNode;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        parent = new HashMap<>();
        sizeMap = new HashMap<>();
        exitsNode = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            add(i);
        }
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            if (!isSame(from, to)) {
                union(from, to);
            } else {
                return false;
            }
        }
        return true;
    }

    public Integer findFather(Integer c) {
        Stack<Integer> cs = new Stack<>();
        Integer f;
        while (!(f = parent.get(c)).equals(c)) {
            c = f;
            cs.add(c);
        }
        while (!cs.isEmpty()) {
            parent.put(cs.pop(), f);
        }
        return f;
    }

    public void add(Integer a) {
        if (exitsNode.add(a)) {
            parent.put(a, a);
            sizeMap.put(a, 1);
        }
    }

    public boolean isSame(Integer a, Integer b) {
        return findFather(a).equals(findFather(b));
    }

    public void union(Integer a, Integer b) {
        Integer aFather = findFather(a);
        Integer bFather = findFather(b);
        if (!aFather.equals(bFather)) {
            int aSize = sizeMap.remove(aFather);
            int bSize = sizeMap.remove(bFather);
            if (aSize > bSize) {
                parent.put(bFather, aFather);
                sizeMap.put(aFather, aSize + bSize);
            } else {
                parent.put(aFather, bFather);
                sizeMap.put(bFather, aSize + bSize);
            }
        }
    }

}

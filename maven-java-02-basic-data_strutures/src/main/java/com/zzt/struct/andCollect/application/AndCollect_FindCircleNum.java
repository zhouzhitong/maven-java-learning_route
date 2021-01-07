package com.zzt.struct.andCollect.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>547. 省份数量
 * https://leetcode-cn.com/problems/number-of-provinces/
 * </>
 *
 * @author zzt
 */
public class AndCollect_FindCircleNum {

    @Test
    public void test01() {
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(findCircleNum(M));
    }

    int[] father;

    public int findCircleNum(int[][] M) {
        father = new int[M.length];
        init(M.length);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (father[i] == i) {
                count++;
            }
        }
        return count;
    }

    public void init(int n) {
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public int findFather(int child) {
        if (father[child] == child) return child;
        return father[child] = findFather(father[child]);
    }

    public void union(int a, int b) {
        int parA = findFather(a);
        int parB = findFather(b);
        if (parA != parB) {
            father[parA] = parB;
        }
    }

}

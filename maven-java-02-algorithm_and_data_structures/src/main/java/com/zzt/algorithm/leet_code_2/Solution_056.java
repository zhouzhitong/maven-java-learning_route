package com.zzt.algorithm.leet_code_2;

import java.util.Arrays;
import java.util.Stack;

/**
 * 描述：<br> 56. 合并区间
 * https://leetcode-cn.com/problems/merge-intervals/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/16 16:11
 */
public class Solution_056 {
    public int[][] merge(int[][] intervals) {
        //先进行一个判空
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        Stack<Integer> startStack = new Stack<>();
        Stack<Integer> endStack = new Stack<>();
        startStack.push(intervals[0][0]);
        endStack.push(intervals[0][1]);
        int start, end;
        for (int i = 1; i < intervals.length; i++) {
            end = endStack.pop();
            start = intervals[i][0];
            if (end >= start) {
                endStack.push(Math.max(end, intervals[i][1]));
            } else {
                endStack.push(end);
                startStack.push(start);
                endStack.push(intervals[i][1]);
            }
        }
        int[][] t = new int[startStack.size()][2];
        int i = startStack.size()-1;
        while (!startStack.isEmpty()) {
            t[i][0] = startStack.pop();
            t[i--][1] = endStack.pop();
        }
        return t;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}
                , {2, 6}
                , {8, 10}
                , {15, 18}
                , {4, 5}};
        int[][] merge = new Solution_056().merge(intervals);
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }

}

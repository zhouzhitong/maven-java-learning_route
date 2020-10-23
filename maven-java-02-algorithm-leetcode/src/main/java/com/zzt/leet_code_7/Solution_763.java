package com.zzt.leet_code_7;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>763. 划分字母区间
 * https://leetcode-cn.com/problems/partition-labels/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/22 9:30
 */
public class Solution_763 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> list = new LinkedList<>();

        int[] dict = new int[26]; // 找出最大的字母出现的index
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            dict[index] = i;
        }

        int preIndex = -1;
        int start = 0;
        int end = 0;

        while (start < S.length()) {
            end = Math.max(end, dict[S.charAt(start) - 'a']);
            int maxIndex = end;
            for (int i = start + 1; i < end; i++) { // 该区间出现的字母，找出最大的index
                maxIndex = Math.max(maxIndex, dict[S.charAt(i) - 'a']);
            }
            start = end + 1;
            if (end == maxIndex) { // index没有超过期望，此时可以分片
                list.add(end - preIndex);
                preIndex = end;
            } else { // index超过期望值，需要重新循环判断
                end = maxIndex;
            }
        }
        return list;
    }

    @Test
    public void test() {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = new Solution_763().partitionLabels(s);
        System.out.println(list);
    }

}

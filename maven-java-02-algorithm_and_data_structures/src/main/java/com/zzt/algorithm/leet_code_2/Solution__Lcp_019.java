package com.zzt.algorithm.leet_code_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br> 19. 秋叶收藏集
 * 网址：https://leetcode-cn.com/problems/UlBDOe/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/8 15:51
 **/
public class Solution__Lcp_019 {
    public int minimumOperations(String leaves) {
        int result = 0;
        char[] cs = leaves.toCharArray();
        List<Integer> listCount = new ArrayList<>();
        if (cs[0] != 'r') {
            cs[0] = 'r';
            result++;
        }
        if (cs[cs.length - 1] != 'r') {
            cs[cs.length - 1] = 'r';
            result++;
        }
        int i = 0;
        while (i < cs.length) {
            char c = cs[i++];
            int count = 1;
            while (i < cs.length && cs[i] == c) {
                i++;
                count++;
            }
            listCount.add(count);
        }
        if (listCount.size() == 1) {
            return 3;
        }
        System.out.println(listCount.size());
        System.out.println(listCount);
        int len = listCount.size() - 2;
        int r = 0, y = 0;
        int count = 2;
        for (int j = 1; j < len; ) {
            y += listCount.get(j++);
            r += listCount.get(j++);
        }
        return result + Math.min(r, y);
    }

    public static void main(String[] args) {
        String leaves = "ryyryyyrryyyyyryyyrrryyyryryyyyryyrrryryyyryrryrrrryyyrrrrryryyrrrrryyyryyryrryryyryyyyryyrryrryryy";
        int i = new Solution__Lcp_019().minimumOperations(leaves);
        System.out.println(i);
    }

}

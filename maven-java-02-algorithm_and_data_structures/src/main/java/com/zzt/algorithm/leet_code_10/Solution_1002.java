package com.zzt.algorithm.leet_code_10;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述：<br>1002. 查找常用字符
 * https://leetcode-cn.com/problems/find-common-characters/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/14 9:59
 */
public class Solution_1002 {

    public List<String> commonChars(String[] A) {
        int[] acs = getCs(A[0]);

        for (int i = 1; i < A.length; i++) {
            int[] aics = getCs(A[i]);

            for (int j = 0; j < acs.length; j++) {
                if (acs[j] > aics[j]) {
                    acs[j] = aics[j];
                }
            }
        }

        List<String> list = new LinkedList<>();
        for (int i = 0; i < acs.length; i++) {
            String e = Character.toString((char) ('a' + i));
            while (acs[i]-- > 0) {
                list.add(e);
            }
        }

        return list;
    }

    private int[] getCs(String s) {
        int[] cs = new int[26];

        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }

        return cs;
    }

    public static void main(String[] args) {

    }

}
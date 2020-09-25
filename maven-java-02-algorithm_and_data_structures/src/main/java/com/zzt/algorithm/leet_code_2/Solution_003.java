package com.zzt.algorithm.leet_code_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/25 10:54
 */
public class Solution_003 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        //初始化
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0;
        for (; r < chars.length; r++) {
            if (map.containsKey(chars[r])) {
                maxLen = Math.max(maxLen, r - l);
                l = Math.max(l, map.get(chars[r]) + 1);
            }
            map.put(chars[r], r);
        }
        return Math.max(maxLen, r - l);
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "pwwkew";
        String s = "abba";
        System.out.println(new Solution_003().lengthOfLongestSubstring(s));
    }

}

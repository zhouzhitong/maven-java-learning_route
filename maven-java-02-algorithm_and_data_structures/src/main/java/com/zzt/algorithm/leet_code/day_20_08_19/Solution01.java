package com.zzt.algorithm.leet_code.day_20_08_19;

/**
 * 描述：<br>题库 -- 算法 --【每日一题】 647. 回文子串
 * 网址：https://leetcode-cn.com/problems/palindromic-substrings/
 * <p>个人思路：
 * 0   1   2   3   4   5
 * a   b   c   c   b   a
 * 0 1 2 3 4 5 6 7 8 9 10
 * ^
 * 中心点：center
 * 1. 中心向两周扩散，依次判断 是否是回文字符串
 * 2. 如果是，则 '+1'，继续玩下判断【递归】，反之直接返回当前中心位置的回文字符串的个数
 * 3. 中心点：center 向右移动一位。。。
 * </>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/19 9:19
 **/
public class Solution01 {

    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        char[] cs = s.toCharArray();
        int count = 0;
        for (int i = 1; i < (cs.length << 1) - 1; i++) {
            /*if (i % 2 != 0) {
                count += centerSubstrings(cs, ((i - 1) >> 1), ((i + 1) >> 1), 0);
            } else {
                count += centerSubstrings(cs, ((i >> 1) - 1), ((i >> 1) + 1), 0);
            }*/
            count += i % 2 != 0
                    ? centerSubstrings(cs, ((i - 1) >> 1), ((i + 1) >> 1), 0)
                    : centerSubstrings(cs, ((i >> 1) - 1), ((i >> 1) + 1), 0);
//            System.out.println("目前数量：--" + count + " -#### 组合: ---> " + ((i - 1) >> 1) + " -- " + ((i + 1) >> 1));
        }
        return count + cs.length;
    }

    private int centerSubstrings(char[] cs, int left, int right, int count) {
        return (left >= 0 && right < cs.length && cs[left] == cs[right])
                ? centerSubstrings(cs, left - 1, right + 1, count + 1)
                : count;
        /*if (left >= 0 && right < cs.length && cs[left] == cs[right]) {
            return centerSubstrings(cs, left - 1, right + 1, count + 1);
        }
        return count;*/
    }


    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(new Solution01().countSubstrings(s));
    }

}

class Solution01_2 {
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0) {
            return 0;
        }
        int count = 0;
        int len = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            count += countPalindrome(cs, i, i);
            count += countPalindrome(cs, i, i + 1);
        }
        return count;
    }

    private int countPalindrome(char[] chars, int start, int end) {
        int curRes = 0;
        int length = chars.length;
        while ((start >= 0) && (end < length) && (chars[start--] == chars[end++])) {
            curRes++;
        }
        return curRes;
    }

    public static void main(String[] args) {
        String s = "abccba";
        System.out.println(new Solution01_2().countSubstrings(s));
    }

}

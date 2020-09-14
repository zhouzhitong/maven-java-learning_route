package com.zzt.algorithm.leet_code.day_20_08_14;

import java.util.Stack;

/**
 * 描述：<br>题库 -- 算法 --【每日一题】 20. 有效的括号 2020/8/14</>
 * <p>网页地址：https://leetcode-cn.com/problems/valid-parentheses/
 * 个人思路：
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/14 14:41
 */
public class Solution01 {

    /**
     * 执行用时： 1 ms  , 在所有 Java 提交中击败了 98.54% 的用户
     * 内存消耗：37.5 MB ,在所有 Java 提交中击败了 84.80% 的用户
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] c = s.toCharArray();
        Stack<Character> characters = new Stack<>();
        int i = 0;
        while (i < c.length) {
            if (c[i] == '(' || c[i] == '[' || c[i] == '{') {
                characters.push(c[i]);
                i++;
            } else {
                if (!characters.isEmpty()) {
                    Character pop = characters.pop();
                    switch (pop) {
                        case '(': {
                            if (')' == c[i]) {
                                i++;
                            } else {
                                return false;
                            }
                            break;
                        }
                        case '[': {
                            if (']' == c[i]) {
                                i++;
                            } else {
                                return false;
                            }
                            break;
                        }
                        case '{': {
                            if ('}' == c[i]) {
                                i++;
                            } else {
                                return false;
                            }
                            break;
                        }
                    }
                } else {
                    return false;
                }
            }
        }

        return characters.isEmpty();
    }

    /*public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> characters = new Stack<>();
        for(char c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                characters.push(c);
            } else {
                if (!characters.isEmpty()) {
                    Character pop = characters.pop();
                    switch (pop) {
                        case '(': {
                            if (')' == c){
                            }else {
                                return false;
                            }
                            break;
                        }
                        case '[': {
                            if (']' == c) {
                            } else {
                                return false;
                            }
                            break;
                        }
                        case '{': {
                            if ('}' == c) {
                            } else {
                                return false;
                            }
                            break;
                        }
                    }
                } else {
                    return false;
                }
            }
        }

        return characters.isEmpty();
    }*/

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.println(new Solution01().isValid(s));
    }

}

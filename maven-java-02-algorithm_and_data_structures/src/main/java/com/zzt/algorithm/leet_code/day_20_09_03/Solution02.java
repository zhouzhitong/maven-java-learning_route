package com.zzt.algorithm.leet_code.day_20_09_03;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述：<br> 22. 括号生成
 *     网址：https://leetcode-cn.com/problems/generate-parentheses/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/3 16:27
 */
public class Solution02 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        backtrack(0, 0, new char[2 * n], result);
        return result;
    }

    //track为当前选择的组合，left为组合中左括号数量，right为组合中右括号数量
    public void backtrack(int left, int right, char[] track, List<String> result) {
        if (left + right == track.length) {
            if (left == right) {
                result.add(new String(track));
            }
            return;
        }
        //如果左括号数量小于右括号数量，不合法
        if (left < right) {
            return;
        }
        //选择左括号作为当前元素
        track[left + right] = '(';
        backtrack(left + 1, right, track, result);
        //选择右括号作为当前元素
        track[left + right] = ')';
        backtrack(left, right + 1, track, result);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution02().generateParenthesis(n));
    }

}

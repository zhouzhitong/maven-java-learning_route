package com.zzt.algorithm.leet_code_2;

import java.util.Arrays;

/**
 * 描述：<br> 344. 反转字符串
 * 网址：https://leetcode-cn.com/problems/reverse-string/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/8 8:12
 **/
public class Solution_344 {

    public void reverseString(char[] s) {
        int length = s.length;
        int len = length >> 1;
        for (int i = 0; i < len; i++) {
            swap(s, i, --length);
        }
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }


    public static void main(String[] args) {
        String s = "hello!";
        char[] chars = s.toCharArray();
        new Solution_344().reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

}

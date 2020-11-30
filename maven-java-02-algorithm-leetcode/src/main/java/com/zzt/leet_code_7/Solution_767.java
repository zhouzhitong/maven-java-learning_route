package com.zzt.leet_code_7;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br> 767. 重构字符串
 * https://leetcode-cn.com/problems/reorganize-string/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/30 17:35
 **/
public class Solution_767 {

    @Test
    public void test01() {
        String s = "aaaabbbbcccc" +
                "ddddeeeegggg" +
                "hhhh";
        String str = reorganizeString(s);
        System.out.println(str);
    }

    public String reorganizeString(String S) {
        if (S == null || S.length() <= 0) {
            return "";
        }
        char[] chars = S.toCharArray();
        /* 1、将S中所有字符 及其 出现次数 录入 letters数组 */
        int[] letters = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            letters[chars[i] - 'a']++;
        }
        /* 2、遍历 letters数组，找到 出现次数最多的 字符，并用 maxIndex 记录器下标 */
        int threshold = (length + 1) >> 1;  // 因为不能相邻，单个字符的阈值为 (length + 1)/2
        int max = 0;
        int maxIndex = 0;
        int curCount;
        for (int i = 0; i < 26; i++) {
            curCount = letters[i];
            if (max < curCount) {
                max = curCount;
                maxIndex = i;
                if (curCount > threshold) {    // 若 最大出现次数 超过 阈值，返回空串
                    return "";
                }
            }
        }
        /* 3、将 当前出现次数最多的字符 分隔安插 */
        char[] resultArray = new char[length];
        int curIndex = 0;
        while (letters[maxIndex]-- > 0) {
            resultArray[curIndex] = (char) (maxIndex + 'a');
            curIndex += 2;
        }
        /* 4、将 其余字符 分隔安插 */
        for (int i = 0; i < 26; i++) {
            while (letters[i]-- > 0) {
                if (curIndex >= length) {
                    curIndex = 1;
                }
                resultArray[curIndex] = (char) (i + 'a');
                curIndex += 2;
            }
        }
        return new String(resultArray);
    }

}

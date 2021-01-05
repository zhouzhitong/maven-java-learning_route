package com.zzt.leet_code_8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述：<br>830. 较大分组的位置
 * https://leetcode-cn.com/problems/positions-of-large-groups/
 * </>
 *
 * @author zzt
 */
public class Solution_830 {

    @Test
    public void test01() {
        String s = "abbxxxxzzy";
        List<List<Integer>> lists = largeGroupPositions(s);
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        int i = 0;
        int len = s.length();
        char[] chars = s.toCharArray();

        while (i < len) {
            int count = 1;
            char c = s.charAt(i);
            int l;
            while ((l = i + count) < len && chars[l] == c) {
                count++;
            }
            if (count > 2) {
                lists.add(Arrays.asList(i, l - 1));
            }
            i = l;
        }
        return lists;
    }

}

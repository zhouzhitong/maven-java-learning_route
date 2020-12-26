package com.zzt.struct.andCollect.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 描述：<br>1202. 交换字符串中的元素
 https://leetcode-cn.com/problems/smallest-string-with-swaps/
 </>
 @author 周志通
 @version 1.0.0
 @date 2020/12/24 23:49 **/
public class AndCollection_SmallestStringWithSwaps {

    @Test
    public void test() {
        String s = "dcab";
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(0, 3));
        lists.add(Arrays.asList(1, 2));
        String s1 = smallestStringWithSwaps(s, lists);
        System.out.println(s1);
    }

    @Test
    public void test02() {
        String s = "cba";
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(0, 1));
        lists.add(Arrays.asList(1, 2));
        String s1 = smallestStringWithSwaps(s, lists);
        System.out.println(s1);
    }

    Map<Integer, Integer> map;
    Set<Integer> set;

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        map = new HashMap<>();
        set = new HashSet<>();
        char[] chars = s.toCharArray();
        for (List<Integer> pair : pairs) {
            Integer a = pair.get(0);
            Integer b = pair.get(1);
            add(a);
            add(b);
            union(a, b);

        }

        for (int from = 0; from < chars.length; from++) {
            if (set.contains(from)) {
                Integer to = findFather(from);
                char c = chars[to];
                chars[to] = chars[from];
                chars[from] = c;
            }
        }

        return new String(chars);
    }

    public void add(Integer a) {
        if (set.add(a)) {
            map.put(a, a);
        }
    }

    public Integer findFather(Integer a) {
        Stack<Integer> stack = new Stack<>();
        Integer b;
        while (!(b = map.get(a)).equals(a)) {
            stack.push(a);
            a = b;
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), b);
        }
        return b;
    }

    public void union(int a, int b) {
        Integer aFather = findFather(a);
        Integer bFather = findFather(b);
        if (!aFather.equals(bFather)) {
            map.put(aFather, bFather);
        }
    }

}

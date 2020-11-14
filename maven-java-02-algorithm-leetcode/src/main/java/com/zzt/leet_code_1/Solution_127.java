package com.zzt.leet_code_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/5 21:39
 **/
public class Solution_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean contains = wordList.contains(endWord);
        if (contains) {
            return dfs(beginWord, endWord, wordList, new HashSet<>(), 0);
        } else {
            return 0;
        }
    }

    private int dfs(String beginWord, String endWord, List<String> wordList, Set<String> set, int count) {
        if (beginWord.equals(endWord)) {
            return count;
        }
        int size = wordList.size();
        int temp;
        for (int i = 0; i < size; i++) {
            String newWord = wordList.get(i);
            if (set.contains(newWord)) {
                continue;
            }
            if (newWord.equals(endWord)) {
                return count;
            }
            String check = check(beginWord, newWord);
            if (newWord.equals(check)) {
                set.add(newWord);
                count = Math.max(dfs(newWord, endWord, wordList, set, count + 1), count);
                set.remove(newWord);
            }
        }
        return 0;
    }

    private String check(String beginWork, String newWord) {
        int count = 1;
        for (int i = 0; i < beginWork.length(); i++) {
            if (beginWork.charAt(i) == newWord.charAt(i)) {
                count++;
            }
            if (count < 0) {
                return beginWork;
            }
        }
        return newWord;
    }


    @Test
    public void test01() {
        List<String> workList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        String beginWord = "hit";
        String endWord = "cog";
        int i = new Solution_127().ladderLength(beginWord, endWord, workList);
        System.out.println(i);
    }

}

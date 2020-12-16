package com.zzt.offer_0;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>
 * </>
 *
 * @author zzt
 */
public class Solution_050 {

    @Test
    public void test01() {
        String s = "abaccdeff";
        char c = firstUniqChar(s);
        System.out.println(c);
    }

    public char firstUniqChar(String s) {
        Set<Character> contain = new HashSet<>();
        Queue<Character> candidates = new ArrayDeque<>();
        if (s == null || s.length() < 1) {
            return ' ';
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!contain.contains(c)) {
                contain.add(c);
                candidates.offer(c);
            } else {
                candidates.remove(c);
            }
        }

        return candidates.isEmpty()?' ':candidates.poll();
    }

}

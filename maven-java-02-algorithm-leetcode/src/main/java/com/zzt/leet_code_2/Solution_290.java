package com.zzt.leet_code_2;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 描述：<br>
 * </>
 *
 * @author zzt
 */
public class Solution_290 {

    @Test
    public void test01() {
        String pattern = "abba", str = "dog cat cat dog";
        boolean b = wordPattern(pattern, str);
        System.out.println(b);
    }

    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            Character c = pattern.charAt(i);
            String value = strs[i];
            String s1 = map.get(c);
            if (s1 == null) {
                if (set.contains(value)) {
                    return false;
                }
                map.put(c, value);
                set.add(value);
            } else if (!s1.equals(value)) {
                return false;
            }
        }
        return true;
    }

}

package com.zzt.leet_code_9;

import org.junit.jupiter.api.Test;

/**
 * 描述：<br>925. 长按键入
 * https://leetcode-cn.com/problems/long-pressed-name/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/21 9:34
 */
public class Solution_925 {

    public boolean isLongPressedName(String name, String typed) {
        int p1 = 0, p2 = 0;
        char preName = 0;
        while (p1 < name.length() && p2 < typed.length()) {
            if (name.charAt(p1) == typed.charAt(p2)) {
                p2++;
                preName = name.charAt(p1++);
            } else if (preName != 0 && preName == typed.charAt(p2)) {
                p2++;
            } else {
                return false;
            }
        }
        while (p2 < typed.length()) {
            if (typed.charAt(p2++) != preName) {
                return false;
            }
        }
        return p1 == name.length();
    }

    @Test
    public void test04() {
        String name = "pyplrz";
        String typed = "ppyypllr";
        boolean longPressedName = new Solution_925().isLongPressedName(name, typed);
        System.out.println(longPressedName);
    }

    @Test
    public void test03() {
        String name = "saeed";
        String typed = "ssaaedd";
        boolean longPressedName = new Solution_925().isLongPressedName(name, typed);
        System.out.println(longPressedName);
    }

    @Test
    public void test02() {
        String name = "laiden";
        String typed = "laiden";
        boolean longPressedName = new Solution_925().isLongPressedName(name, typed);
        System.out.println(longPressedName);
    }

    @Test
    public void test01() {
        String name = "leelee";
        String typed = "lleeelee";
        boolean longPressedName = new Solution_925().isLongPressedName(name, typed);
        System.out.println(longPressedName);
    }

}

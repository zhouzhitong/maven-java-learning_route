package com.zzt.algorithm.leet_code_2;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述：<br>13. 罗马数字转整数
 * 网址：https://leetcode-cn.com/problems/roman-to-integer/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/6 0:16
 **/
public class Solution_013 {

    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }
        //建立罗马数字 到 阿拉伯数字的映射关系
        Map<Character, Integer> map = getMap();
        int ans = 0;
        //每次我们都匹配一个字母，注意因为要获取 i+1 位置的字母，所以循环终止条件
        //是字符串的最大长度-1
        for (int i = 0; i < s.length() - 1; ++i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }
        //最后不要忘记收尾操作，把遗留的字母也加上
        ans += map.get(s.charAt(s.length() - 1));
        return ans;
    }

    private Map<Character, Integer> getMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

    public static void main(String[] args) {
        String str = "MCMXCIV"; // 1994
        int i = new Solution_013().romanToInt(str);
        System.out.println(i);
    }

}

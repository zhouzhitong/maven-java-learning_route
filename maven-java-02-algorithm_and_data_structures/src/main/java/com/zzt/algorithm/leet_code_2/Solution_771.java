package com.zzt.algorithm.leet_code_2;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 描述：<br> 771. 宝石与石头
 * 网址：https://leetcode-cn.com/problems/jewels-and-stones/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/2 21:41
 **/
public class Solution_771 {

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        char[] chars = J.toCharArray();
        StringBuilder buffer = new StringBuilder("(");
        for (char aChar : chars) {
            buffer.append(aChar).append("|");
        }
        buffer.deleteCharAt(buffer.length()-1);
        buffer.append(")");
        String regex = buffer.toString();
        System.out.println(regex);
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(S);
        while (matcher.find()){
            count++;
        }
        return count;
    }

    /*public int numJewelsInStones(String J, String S) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        char[] chars = S.toCharArray();
        for (char aChar : chars) {
            if (set.contains(aChar)) {
                count++;
            }
        }
        return count;
    }*/


    public static void main(String[] args) {
        String J = "aA";
        String S = "aAAbbbbb";
        System.out.println(new Solution_771().numJewelsInStones(J, S));
    }

}

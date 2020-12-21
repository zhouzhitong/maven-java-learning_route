package com.zzt.struct.andCollect.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>990. 等式方程的可满足性
 * https://leetcode-cn.com/problems/satisfiability-of-equality-equations/
 * </>
 *
 * @author zzt
 */
public class AndCollect_EquationsPossible {

    @Test
    public void test01() {
//        String[] equations = {"a==b", "b!=c", "a==c"};
        String[] equations = {"a==b", "b==a"};
        boolean b = equationsPossible(equations);
        System.out.println(b);
    }

    public boolean equationsPossible(String[] equations) {
        Set<Integer> set = new HashSet<>();
        AndCollect collect = new AndCollect();
        Integer i = -1;
        for (String equation : equations) {
            i++;
            char a = equation.charAt(0);
            char c = equation.charAt(1);
            char b = equation.charAt(3);
            collect.addNode(a);
            collect.addNode(b);
            if (c == '=') {
                set.add(i);
                collect.unionEqual(a, b);
            }
        }
        for (int j = 0; j < equations.length; j++) {
            if (!set.contains(j)) {
                char a = equations[j].charAt(0);
                char b = equations[j].charAt(3);
                if (collect.findFather(a) == collect.findFather(b)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class AndCollect {

        private Map<Character, Character> sameMap;
        private Set<Character> existNode;

        public AndCollect() {
            this.sameMap = new HashMap<>();
            this.existNode = new HashSet<>();
        }

        public void addNode(char c) {
            if (existNode.add(c)) {
                sameMap.put(c, c);
            }
        }

        public Character findFather(Character a) {
            Stack<Character> stack = new Stack<>();
            Character help;
            while ((help = sameMap.get(a)) != a) {
                help = sameMap.get(a);
                stack.push(help);
                a = help;
            }
            while (!stack.isEmpty()) {
                sameMap.put(stack.pop(), help);
            }
            return help;
        }

        public void unionEqual(char a, char b) {
            char aParent = findFather(a);
            char bParent = findFather(b);
            if (aParent != bParent) {
                sameMap.put(aParent, bParent);
            }
        }

    }

}

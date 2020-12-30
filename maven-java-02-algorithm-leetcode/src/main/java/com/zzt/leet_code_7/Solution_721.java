package com.zzt.leet_code_7;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>  721. 账户合并
 * https://leetcode-cn.com/problems/accounts-merge/
 * </>
 *
 * @author zzt
 */
public class Solution_721 {

    @Test
    public void test01() {

    }

    Map<String, String> parentMap;
    Map<String, Integer> sizeMap;
    Set<String> set;

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> map = new HashMap<>();
        parentMap = new HashMap<>();
        sizeMap = new HashMap<>();
        set = new HashSet<>();
        for (List<String> account : accounts) {
            if (account.size() < 2) continue;
            String name = account.get(0);
            String email = account.get(1);
            map.put(email, name);
            add(email);
            for (int i = 2; i < account.size(); i++) {
                String b = account.get(i);
                add(b);
                union(email, b);
            }
        }

        for (String email : set) {

        }


        return null;
    }

    public void add(String email) {
        if (set.add(email)) {
            parentMap.put(email, email);
            sizeMap.put(email, 1);
        }
    }

    public String findFather(String email) {
        Stack<String> childStack = new Stack<>();
        String parent;
        while (!(parent = parentMap.get(email)).equals(email)) {
            childStack.push(parent);
            email = parent;
        }
        while (!childStack.isEmpty()) {
            parentMap.put(childStack.pop(), parent);
        }
        return parent;
    }

    public boolean isSame(String a, String b) {
        return findFather(a).equals(findFather(b));
    }

    public void union(String a, String b) {
        String aFather = findFather(a);
        String bFather = findFather(b);
        if (!aFather.equals(bFather)) {
            int aSize = sizeMap.remove(aFather);
            int bSize = sizeMap.remove(bFather);
            if (aSize > bSize) {
                parentMap.put(bFather, aFather);
                sizeMap.put(aFather, aSize + bSize);
            } else {
                parentMap.put(aFather, bFather);
                sizeMap.put(bFather, aSize + bSize);
            }

        }
    }

}

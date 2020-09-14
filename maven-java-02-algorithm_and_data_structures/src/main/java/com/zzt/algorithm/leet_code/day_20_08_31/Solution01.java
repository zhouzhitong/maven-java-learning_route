package com.zzt.algorithm.leet_code.day_20_08_31;

import java.util.*;

/**
 * 描述：<br> 841. 钥匙和房间
 * 网址：https://leetcode-cn.com/problems/keys-and-rooms/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/31 15:52
 */
public class Solution01 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() <= 1) {
            return true;
        }
        if (rooms.get(0).size() < 1) {
            return false;
        }
        int len = rooms.size();
        Set<Integer> keys = new HashSet<>(rooms.get(0));
        keys.remove(0);
        Set<Integer> newKeys;
        int i = 0;
        int hasKeys = keys.size();
        while (i < len) {
            newKeys = new HashSet<>(keys);
            for (Integer key : newKeys) {
                if (key < len) {
                    keys.addAll(rooms.get(key));
                } else {
                    hasKeys--;
                }
            }
            if (hasKeys == len - 1) {
                return true;
            } else {
                keys.remove(0);
                hasKeys = keys.size();
            }
            i++;
        }
        System.out.println(keys.size() + " -- " + hasKeys);
        return false;
    }

    public static void main(String[] args) {
        //[[1,3],[3,0,1],[2],[0]]
        //[[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(1, 3))));
        rooms.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(3, 0, 1))));
        rooms.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(2))));
        rooms.addAll(Collections.singleton(new ArrayList<>(Arrays.asList(0))));
        System.out.println(new Solution01().canVisitAllRooms(rooms));
    }

}

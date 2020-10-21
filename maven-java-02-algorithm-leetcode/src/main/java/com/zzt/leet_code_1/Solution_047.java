package com.zzt.leet_code_1;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>47. 全排列 II
 * https://leetcode-cn.com/problems/permutations-ii/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/21 13:55
 */
public class Solution_047 {

    /*public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        Set<List<Integer>> set = new HashSet<>();
        process(set, list, new ArrayList<>());
        return new ArrayList<>(set);
    }

    private void process(Set<List<Integer>> set, List<Integer> nums, List<Integer> list) {
        if (nums.size() == 0) {
            if (!set.contains(list)) {
                set.add(new ArrayList<>(list));
            }
            return;
        }
        Integer temp;
        for (int i = 0; i < nums.size(); i++) {
            temp = nums.get(i);
            list.add(temp);
            nums.remove(temp);
            process(set, new ArrayList<>(nums), list);
            nums.add(i, temp);
            list.remove(list.size() - 1);
        }
    }*/

    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
        }
        Set<List<Integer>> set = new HashSet<>();
        dfs(set, new ArrayList<>(), map, nums.length);
        return new ArrayList<>(set);
    }

    private void dfs(Set<List<Integer>> result, List<Integer> list, Map<Integer, Integer> map, int length) {
        if (list.size() == length) {
            if (!result.contains(list)){
                result.add(new ArrayList<>(list));
            }
            return;
        }
        Set<Integer> set = map.keySet();
        for (Integer key : set) {
            Integer value = map.get(key);
            if (value > 0) {
                map.put(key, value - 1);
                list.add(key);
                dfs(result, list, map, length);
                list.remove(list.size() - 1);
                map.put(key, value);
            }
        }
    }

    @Test
    public void test02() {
        // [[2,1,2,1],[2,2,1,1],[2,1,1,2],[1,2,2,1],[1,1,2,2]]
        // [[1,1,2,2],[1,2,1,2],[1,2,2,1],[2,1,1,2],[2,1,2,1],[2,2,1,1]]
        int[] nums = {2, 2, 1, 1};
        List<List<Integer>> lists = new Solution_047().permuteUnique(nums);
        System.out.println("=================");
        lists.forEach(System.out::println);
    }

    @Test
    public void test01() {
        int[] nums = {1, 1, 2};
        List<List<Integer>> lists = new Solution_047().permuteUnique(nums);
        lists.forEach(System.out::println);
    }

    @Test
    public void test() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(0, 4);
        System.out.println(list);
    }
}

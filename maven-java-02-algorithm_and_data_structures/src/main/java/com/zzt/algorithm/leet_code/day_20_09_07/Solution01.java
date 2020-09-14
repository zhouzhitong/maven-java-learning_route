package com.zzt.algorithm.leet_code.day_20_09_07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 描述：<br> 347. 前 K 个高频元素
 * 网址：https://leetcode-cn.com/problems/top-k-frequent-elements/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/7 17:40
 */
public class Solution01 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(
                ((o1, o2) -> map.get(o1) - map.get(o2))
        );
        for (int num : map.keySet()) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        int[] result = new int[heap.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    private class Node implements Comparable<Node> {
        private Integer num;
        private Integer count;

        public Node(Integer num, Integer count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Node node) {
            if (this.count > node.count) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public boolean equals(Object o) {

            Node node = (Node) o;
            if (this.num.equals(node.num)) {
                return true;
            } else {
                return false;
            }

        }

        @Override
        public int hashCode() {
            return num;
        }
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 3};
        int k = 2;
        System.out.println(Arrays.toString(new Solution01().topKFrequent(nums, k)));
    }

}

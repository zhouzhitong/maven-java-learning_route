package com.zzt.algorithm_2.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 描述：<br>方案一：哈夫曼树
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/6 0:14
 **/
public class GreedyDemo02_CopperPlate {

    // 哈弗曼树
    public int getMinCost(int total, int[] targets) {
        int cost = 0;
        int sum = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int target : targets) {
            queue.add(target);
            sum += target;
        }
        if (sum > total) {
            throw new RuntimeException("所给的长度不够长！！！");
        }
        int temp;
        while (queue.size() > 1) {
            temp = queue.poll() + queue.poll();
            cost += temp;
            queue.add(temp);
        }
        return cost;
    }

    // 贪心策略：
    public int getMinCost2(int total, int[] targets) {
        int cost = 0;
        int sum = 0;
        Arrays.sort(targets);
        int count = 1;
        int index = targets.length - 1;
        while (index >= 0) {
            sum += targets[index];
            cost += targets[index--] * (count++);
        }
        if (sum > total) {
            throw new RuntimeException("所给的长度不够长！！！");
        }
        return cost - targets[0];
    }

    public static void main(String[] args) {
        int[] targets = {10, 30, 20};   // 190
        int total = 100;
        int minCost = new GreedyDemo02_CopperPlate().getMinCost2(total, targets);
        System.out.println(minCost);
    }

}

package com.zzt.leet_code_6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 描述：<br>621. 任务调度器
 * https://leetcode-cn.com/problems/task-scheduler/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/12/5 14:07
 */
public class Solution_621 {

    @Test
    public void test01() {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'C', 'C', 'C', 'C', 'D', 'E'};
        int n = 2;
        int i = leastInterval(tasks, n);
        System.out.println(i);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for (char task : tasks) {
            buckets[task - 'A']++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 1;
        for (int i = 25; i >= 1; i--) {
            if (buckets[i] == buckets[i - 1])
                maxCount++;
            else
                break;
        }
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(res, tasks.length);
    }

}

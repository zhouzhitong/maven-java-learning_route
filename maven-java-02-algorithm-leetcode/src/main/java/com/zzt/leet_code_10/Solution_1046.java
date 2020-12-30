package com.zzt.leet_code_10;

import org.junit.jupiter.api.Test;
import java.util.PriorityQueue;

/**
 * 描述：<br>1046. 最后一块石头的重量
 * https://leetcode-cn.com/problems/last-stone-weight/
 * </>
 *
 * @author zzt
 */
public class Solution_1046 {

    @Test
    public void test01() {
        int[] stones = {2, 7, 4, 1, 8};
        int i = lastStoneWeight(stones);
        System.out.println(i);
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            queue.offer(stone);
        }
        while (queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            int d = x-y;
            if (d>0){
                queue.offer(x-y);
            }
        }
        return queue.poll();
    }

}

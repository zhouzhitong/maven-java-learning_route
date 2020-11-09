package com.zzt.leet_code_9;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 描述：<br>973. 最接近原点的 K 个点
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/9 11:28
 */
public class Solution_973 {

    public int[][] kClosest(int[][] points, int K) {
        if (points.length <= K) {
            return points;
        }
        Arrays.sort(points, Comparator.comparingInt(v -> (v[0] * v[0] + v[1] * v[1])));
        int[][] result = new int[K][2];
        int index = 0;
        while (index < K) {
            result[index] = points[index];
            index++;
        }
        return result;
    }

    /*public int[][] kClosest(int[][] points, int K) {
        if (points.length <= K) {
            return points;
        }
        Arrays.sort(points,Comparator.comparingInt(v -> (v[0] * v[0] + v[1] * v[1])));
        PriorityQueue<int[]> queue1 = new PriorityQueue<>(
                Comparator.comparingInt(v -> (v[0] * v[0] + v[1] * v[1])));
        queue1.addAll(Arrays.asList(points));
        int[][] result = new int[K][2];
        int index = 0;
        while (index < K) {
            result[index++] = queue1.poll();
        }
        return result;
    }*/

    @Test
    public void test01() {
        int[][] points = {{1, 3}, {-2, 2}, {-1, 3}};
        int k = 1;
        int[][] ints = new Solution_973().kClosest(points, k);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }

}

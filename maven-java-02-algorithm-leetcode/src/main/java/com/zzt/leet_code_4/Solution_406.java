package com.zzt.leet_code_4;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：<br>406. 根据身高重建队列
 * https://leetcode-cn.com/problems/queue-reconstruction-by-height/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/16 14:14
 */
public class Solution_406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (v1, v2) -> {
            int i = v1[1] - v2[1];
            if (i == 0) {
                return v1[0] - v2[0];
            } else {
                return i;
            }
        });
        List<int[]> result = new ArrayList<>();
        int index;
        for (int[] person : people) {
            index = person[1];
            int i;
            for (i = 0; i < result.size(); i++) {
                int[] temp = result.get(i);
                if (index == 0) {
                    if (temp[0] > person[0]) {
                        break;
                    }
                } else {
                    if (temp[0] >= person[0]) {
                        index--;
                    }
                }
            }
            result.add(i, person);
        }
        AtomicInteger i = new AtomicInteger();
        result.forEach(a -> people[i.getAndIncrement()] = a);
        return people;
    }

    @Test
    public void test01() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = new Solution_406().reconstructQueue(people);
        if (ints != null) {
            for (int[] anInt : ints) System.out.println(Arrays.toString(anInt));
        }
    }

}

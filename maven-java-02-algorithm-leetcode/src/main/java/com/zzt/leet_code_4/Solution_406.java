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
 */
public class Solution_406 {

    @Test
    public void test01() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] ints = reconstructQueue(people);
        if (ints != null) {
            for (int[] anInt : ints) System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        quickSort(people, 0, people.length - 1);
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) list.add(p[1], p);
        return list.toArray(new int[0][2]);
    }

    private void quickSort(int[][] arr, int left, int right) {
        if (left >= right) return;
        int pivot = partition(arr, left, right);
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    private int partition(int[][] arr, int l, int r) {
        int[] pivot = arr[l];
        while (l < r) {
            while (l < r) {
                if (arr[r][0] > pivot[0] || arr[r][0] == pivot[0] && arr[r][1] < pivot[1]) {
                    arr[l++] = arr[r];
                    break;
                }
                r--;
            }
            while (l < r) {
                if (arr[l][0] < pivot[0] || arr[l][0] == pivot[0] && arr[l][1] > pivot[1]) {
                    arr[r--] = arr[l];
                    break;
                }
                l++;
            }
        }
        arr[l] = pivot;
        return l;
    }

    /*public int[][] reconstructQueue(int[][] people) {
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
        for (int i = 0; i < result.size(); i++) people[i] = result.get(i);
        return people;
    }*/

}

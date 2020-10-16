package com.zzt.algorithm.leet_code_10;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 描述：<br>977. 有序数组的平方
 * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/16 10:22
 */
public class Solution_977 {

    public int[] sortedSquares(int[] a) {
        int[] t = new int[a.length];
        int i = 0, j = a.length - 1;
        int len = j;
        int left, right;
        while (len > -1) {
            left = a[i] * a[i];
            right = a[j] * a[j];
            if (left > right) {
                t[len--] = left;
                i++;
            } else {
                t[len--] = right;
                j--;
            }
        }
        return t;
    }

    /*public int[] sortedSquares(int[] a) {
        int[] t = new int[a.length];
        int i = 0;
        for (int j : a) {
            if (j >= 0) {
                break;
            } else {
                i++;
            }
        }
        int j = i - 1;
        int m = 0;
        while (i < a.length && j > -1) {
            int t1 = a[i] * a[i], t2 = a[j] * a[j];
            if (t1 < t2) {
                t[m++] = t1;
                i++;
            } else {
                t[m++] = t2;
                j--;
            }
        }
        while (i < a.length) {
            t[m++] = a[i] * a[i++];
        }
        while (j > -1) {
            t[m++] = a[j] * a[j--];
        }
        return t;
    }*/

    /*public int[] sortedSquares(int[] a) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : a) {
            queue.add(i * i);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = queue.poll();
        }
        return a;
    }*/

    public static void main(String[] args) {
        int[] a = {-4, -1, 0, 3, 10};
        int[] ints = new Solution_977().sortedSquares(a);
        System.out.println(Arrays.toString(ints));

    }

}

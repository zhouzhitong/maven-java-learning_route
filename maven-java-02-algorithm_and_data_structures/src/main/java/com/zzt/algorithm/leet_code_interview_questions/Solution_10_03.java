package com.zzt.algorithm.leet_code_interview_questions;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/16 22:49
 **/
public class Solution_10_03 {
    public int search(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if (arr[mid] >= target) {// 判断
                if (arr[r] < arr[mid] && arr[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (arr[mid] < arr[l] && target >= arr[l]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return l < arr.length && arr[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int target = 5;
        int search = new Solution_10_03().search(arr, target);
        System.out.println(search);
    }

}

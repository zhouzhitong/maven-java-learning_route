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
        int p;
        int leftVal;
        int l = 0, r = arr.length - 1;
        int mid;
        while (l < r) {
            leftVal = arr[l];
            if (leftVal == target) {
                return l;
            }
            p = r + ((l - r) >> 1) + 1;
            mid = arr[p];
            if (target == mid) {
                return p;
            } else if (target < mid) {
                r = p - 1;
            } else {
                if (target < leftVal) {
                    l = p + 1;
                } else {
                    r = p - 1;
                }
            }
        }
        return arr[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 4, 5, 5, 12, 17, 17, 20, 20, 21, 22
                , 22, 24, 24, 27, 29, 30, 32, 41, 41, 45, 45
                , 46, 47, 49, 53, 57, 57, 63, 63, -63, -63, -62
                , -56, -52, -48, -47, -44, -43, -43, -42, -41
                , -39, -39, -37, -34, -33, -32, -32, -29, -26
                , -25, -23, -16, -13, -11, -8, -7, -7, -6, -4, -2, -2};
        int target = -23;
        int search = new Solution_10_03().search(arr, target);
        System.out.println(search);
    }

}

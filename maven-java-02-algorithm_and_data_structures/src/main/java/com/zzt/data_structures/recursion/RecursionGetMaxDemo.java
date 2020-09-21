package com.zzt.data_structures.recursion;

/**
 * 描述：<br>
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/9/21 10:14
 **/
public class RecursionGetMaxDemo {

    public static void main(String[] args) {
//        int a = (0 - 1) >> 1;
//        System.out.println(1);
        int[] arr = {1, 2, 3, 56, 61, 2, 1, 5, 7};
        Integer maxCount = getMaxCount(arr, 0, arr.length - 1);
        System.out.println(maxCount);
    }

    public static Integer getMaxCount(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = right + ((left - right) >> 1);
//        int mid = (right + left) >> 1;
        int leftMax = getMaxCount(arr, left, mid);
        int rightMax = getMaxCount(arr, mid + 1, right);
        return Math.max(leftMax, rightMax);
    }

}

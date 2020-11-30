package com.zzt.leet_code_4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 描述：<br>493. 翻转对
 * https://leetcode-cn.com/problems/reverse-pairs/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/30 20:14
 **/
public class Solution_493 {

    @Test
    public void test01() {

    }

    long[] tmp;

    //区间和在[lower, upper]中的总和
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] rangeSum = new long[nums.length + 1];
        tmp = new long[nums.length + 1];
        rangeSum[0] = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            rangeSum[i + 1] = sum;
        }
        return megerSort(rangeSum, 0, rangeSum.length - 1, lower, upper);

    }

    private int megerSort(long[] nums, int low, int high,
                          int lower, int upper) {
        if (low == high) return 0;
        int mid = (low + high) / 2;
        int total = megerSort(nums, low, mid, lower, upper) + megerSort(nums, mid + 1, high, lower, upper);
        int res = countSubNum(Arrays.copyOfRange(nums, low, mid + 1), Arrays.copyOfRange(nums, mid + 1, high + 1), lower, upper);
        int x1 = low;
        int x2 = mid + 1;
        int idx = low;
        while (x1 <= mid & x2 <= high) {
            if (nums[x1] < nums[x2]) {
                tmp[idx++] = nums[x1++];
            } else {
                tmp[idx++] = nums[x2++];
            }
        }
        if (x2 <= high) x1 = x2;
        while (idx <= high) tmp[idx++] = nums[x1++];
        if (high + 1 - low >= 0) System.arraycopy(tmp, low, nums, low, high + 1 - low);
        //System.out.println("n" + (total+res));
        return (total + res);
    }

    //两个升序的数组，求下标对儿之差b[j]-a[i]在[low, high]之间的个数
    public int countSubNum(long[] a, long[] b,
                           int low, int high) {
        int left = 0;
        int right = 0;
        int total = 0;
        for (long l : a) {
            while (left < b.length && b[left] < l + low) left++;
            while (right < b.length && b[right] <= l + high) right++;
            total += (right - left);
            //System.out.println("a[i]: " + a[i] +" 有 "+ (right-left) +" <"+ left +"," + (right-1)+ "> 个符合要求数据");
        }
        //System.out.println("一共有 " + total +" 组");
        return total;
    }

}

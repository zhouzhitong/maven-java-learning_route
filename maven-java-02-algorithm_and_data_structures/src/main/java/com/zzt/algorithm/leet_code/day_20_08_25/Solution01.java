package com.zzt.algorithm.leet_code.day_20_08_25;

/**
 * 描述：<br>148. 排序链表
 * 网址：https://leetcode-cn.com/problems/sort-list/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/8/25 17:04
 */
public class Solution01 {
    public ListNode sortList(ListNode head) {
        return quickSort(head, null);
    }

    // sort[lo..hi), hi is exclusive
    private ListNode quickSort(ListNode lo, ListNode hi) {
        if (lo == hi)
            return lo;
        ListNode k = partition(lo, hi);
        quickSort(lo, k);
        quickSort(k.next, hi);
        return lo;
    }

    // using low bound as pivot
    // partite [lo..hi)
    private ListNode partition(ListNode lo, ListNode hi) {
        ListNode k = lo;    // partition point
        int pivot = lo.val;
        for (ListNode i = lo.next; i != hi && i != null; i = i.next) {
            if (i.val < pivot) {
                swap(k.next, i);
                k = k.next;
            }
        }
        swap(lo, k);
        return k;
    }

    private void swap(ListNode a, ListNode b) {
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }

    public static void main(String[] args) {

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
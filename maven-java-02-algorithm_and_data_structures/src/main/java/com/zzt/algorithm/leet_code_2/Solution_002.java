package com.zzt.algorithm.leet_code_2;

import java.util.List;

/**
 * 描述：<br> 2. 两数相加（中等）
 * 网址：https://leetcode-cn.com/problems/add-two-numbers/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/4 10:34
 **/
public class Solution_002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(-1);
        ListNode next = root;
        int exceed = 0;
        while (l1 != null && l2 != null) {
            next.next = new ListNode((l1.val + l2.val + exceed) % 10);
            exceed = (l1.val + l2.val + exceed) / 10;
            next = next.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            next.next = new ListNode((l1.val + exceed) % 10);
            exceed = (l1.val + exceed) / 10;
            next = next.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            next.next = new ListNode((l2.val + exceed) % 10);
            exceed = (l2.val + exceed) / 10;
            next = next.next;
            l2 = l2.next;
        }
        if (exceed != 0) {
            next.next = new ListNode(exceed);
        }
        return root.next;
    }

    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0) ;
        test(root,l1,l2,0) ;
        return root.next ;
    }

    private void test(ListNode root ,ListNode l1, ListNode l2,int exceed ) {
        if (l1 == null && l2 == null && exceed == 0){
            return;
        }
        int temp = (l1!=null?l1.val:0) + (l2!=null?l2.val:0)+ exceed ;
        root.next = new ListNode(temp%10) ;
        test(root.next,l1!=null?l1.next:null,l2!=null?l2.next:null,temp/10) ;
    }*/

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = new Solution_002().addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

}

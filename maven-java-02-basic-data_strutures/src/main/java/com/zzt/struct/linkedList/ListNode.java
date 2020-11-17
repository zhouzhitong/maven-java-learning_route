//package com.zzt.struct.linkedList;
//
//import java.util.List;
//
///**
// * 描述：<br>
// * </>
// *
// * @author 周志通
// * @version 1.0.0
// * @date 2020/11/17 8:59
// */
//public class ListNode {
//
//    public static void main(String[] args) {
//        ListNode listNode = new ListNode(1);
//        listNode.addNode(2);
//        listNode.addNode(3);
//        listNode.addNode(4);
//        System.out.println(listNode.listLength());
////        listNode.print();
//    }
//
//
//    ListNode head;  // 头结点
//    ListNode next;  // 尾节点
//    int data;   // 节点的值
//
//    ListNode() {
//    }
//
//    ListNode(int data) {
//        this.data = data;
//        head = new ListNode();
//        head.data = data;
//        this.next = head;
//    }
//
//    // 查看数组的长度
//    public int listLength() {
//        ListNode temp = head;
//        int length = 0;
//        while (temp != null) {// 从头节点开始遍历，直到遇到 null 结束，就是链表的长度
//            length++;
//            temp = temp.next;
//        }
//        return length - 1;
//    }
//
//    // 添加数据
//    public void addNode(int data) {
//        ListNode node = new ListNode(data);
//        if (head == null) {
//            head = node;
//            this.next = head;
//        } else {
//            this.next.next = node;
//            this.next = node;
//        }
//    }
//
//    // 遍历链表中所有的数据
//    public void print() {
//        ListNode temp = head;
//        while (temp != null) {
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//    }
//
//    @Override
//    public String toString() {
//        return "ListNode{" +
//                "data=" + data +
//                '}';
//    }
//}

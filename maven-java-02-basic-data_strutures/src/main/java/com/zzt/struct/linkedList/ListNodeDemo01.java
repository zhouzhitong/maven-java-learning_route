package com.zzt.struct.linkedList;

/**
 * 描述：<br>
 * </>
 * @author 周志通
 * @version 1.0.0
 * @date 2020/11/17 10:35
 */
public class ListNodeDemo01 {

    public static void main(String[] args) {
        ListNodeOperate operate = new ListNodeOperate(1);
        operate.addNode(2);
        operate.addNode(3);
        operate.addNode(4);
        operate.deleteNode(0);
        operate.addNode(5);
        operate.print();

    }

}

class ListNodeOperate {
    ListNode headNode;
    ListNode currentNode;
    int length;

    public ListNodeOperate(int data) {
        ListNode node = new ListNode(data);
        headNode = node;
        currentNode = node;
        length = 1;
    }

    public void addNode(int data) {
        ListNode node = new ListNode(data);
        currentNode.next = node;
        currentNode = currentNode.next;
        length++;
    }

    public void deleteNode(int index) {
        if (index < 0 || index > length) {
            System.out.println("不存在该位置的值");
        }
        if (index == 0) {
            headNode = headNode.next;
            return;
        }
        ListNode pre = headNode;
        ListNode node = pre.next;
        for (int i = 0; i < index - 1; i++) {
            pre = node;
            node = node.next;
        }
        pre.next = node.next;

    }

    public void findNode(int index){

    }

    public void print() {
        ListNode temp = headNode;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

}

class ListNode {
    ListNode next;
    int data;

    public ListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                '}';
    }
}

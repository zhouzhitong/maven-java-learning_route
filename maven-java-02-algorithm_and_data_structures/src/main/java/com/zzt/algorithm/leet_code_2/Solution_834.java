package com.zzt.algorithm.leet_code_2;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：<br> 834. 树中距离之和
 * 网址：https://leetcode-cn.com/problems/sum-of-distances-in-tree/
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/1 23:51
 **/
public class Solution_834 {

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] result = new int[N];
        List<Node> nodeList = new ArrayList<>(N);//
        for (int i = 0; i < N; i++) {
            nodeList.add(new Node(i));
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            Node nodeA = nodeList.get(a);
            Node nodeB = nodeList.get(b);
            nodeA.link(nodeB);
        }

        Node root = nodeList.get(0);
        root.traverse();
        root.initiate();
        root.totalDistance = root.subDistance;
        root.calculateDistance(N);
        for (int i = 0; i < N; i++) {
            result[i] = nodeList.get(i).totalDistance;
        }

        return result;
    }

    private static class Node {
        int val;
        Node parent;        // 父节点信息
        List<Node> nodes;   // 子节点个集合
        int size;           //
        boolean visited;
        int subDistance;
        int totalDistance;

        public Node(int val) {
            this.val = val;
            this.parent = null;
            this.nodes = new ArrayList<>();
            this.size = 1;
            this.visited = false;
            this.subDistance = 0;
            this.totalDistance = 0;
        }

        public void link(Node anotherNode) {
            this.nodes.add(anotherNode);
            anotherNode.nodes.add(this);// 无向图，反向指向。
        }

        public void traverse() {
            // System.out.println("A");
            for (Node node : nodes) {
                node.parent = this;
                node.nodes.remove(this);
                node.traverse();
            }
        }

        public void initiate() {
            for (Node node : nodes) {
                node.initiate();
                this.size += node.size;
                this.subDistance += node.subDistance;
                this.subDistance += node.size;
            }
        }

        public void calculateDistance(int N) {
            for (Node node : nodes) {
                node.totalDistance = this.totalDistance + N - node.size * 2;
                node.calculateDistance(N);
            }
        }
    }

    public static void main(String[] args) {

    }

}

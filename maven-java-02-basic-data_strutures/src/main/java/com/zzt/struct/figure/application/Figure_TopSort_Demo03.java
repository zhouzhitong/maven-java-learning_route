package com.zzt.struct.figure.application;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 描述：<br>图的拓扑排序：通过节点最大深度进行排序
 例如：节点 X 的深度 8，节点 Y 的深度 10
 节点 Y 一定在 X 的前面
 </>
 @author zzt */
public class Figure_TopSort_Demo03 {

    @Test
    public void test01() {
        Node node1, node2, node3, node4, node5;
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);
        node5 = new Node(5);
        List<Node> nodes = new ArrayList<>(Arrays.asList(node1, node2, node3, node4, node5));

        node1.nextNodes.addAll(Arrays.asList(node2, node4, node5));
        node2.nextNodes.addAll(Arrays.asList(node5));
        node3.nextNodes.addAll(Arrays.asList(node5));
        node4.nextNodes.addAll(Arrays.asList(node5));
        nodes = topSort(nodes);
        System.out.println(nodes);
    }

    public static List<Node> topSort(List<Node> nodes) {
        Map<Node, Record> map = new HashMap<>();
        for (Node node : nodes) {
            pfs(node, map);
        }
        List<Record> records = new ArrayList<>(map.values());
        records.sort(new RecordComparator());
        List<Node> newNodes = new ArrayList<>();
        for (Record record : records) {
            newNodes.add(record.node);
        }
        return newNodes;
    }

    private static Record pfs(Node cur, Map<Node, Record> map) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        int nodes = 0;
        for (Node nextNode : cur.nextNodes) {
            nodes = Math.max(pfs(nextNode, map).deep, nodes);
        }
        Record record = new Record(cur, nodes + 1);
        map.put(cur, record);
        return record;
    }

    /** 对节点信息的封装：节点信息 + 点次信息 */
    private static class Record {
        Node node;
        int deep;

        public Record(Node node, int deep) {
            this.node = node;
            this.deep = deep;
        }
    }

    private static class RecordComparator implements Comparator<Record> {
        @Override
        public int compare(Record o1, Record o2) {
            return Integer.compare(o2.deep, o1.deep);
        }
    }

    private class Node {
        int val;
        List<Node> nextNodes;

        public Node(int val) {
            this.val = val;
            this.nextNodes = new ArrayList<>();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

}

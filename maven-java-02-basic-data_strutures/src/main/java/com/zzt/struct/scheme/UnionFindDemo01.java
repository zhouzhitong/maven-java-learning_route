package com.zzt.struct.scheme;

import com.zzt.struct.scheme.model.Edge;
import com.zzt.struct.scheme.model.Node;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 描述：<br>数据结构 ---> 图结构
 * </>
 *
 * @author 周志通
 * @version 1.0.0
 * @date 2020/10/20 18:10
 */
public class UnionFindDemo01 {


    private Integer out;

    /**
     * a(1) —— 3 —— b(2)
     * |  \        /
     * 7   2     1
     * |    \   /
     * c(3)  d(4)
     */
    @Test
    public void test01() {
        List<Node<Integer, Integer>> nodes = getNode();
        List<Edge<Integer>> edges = getEdges(nodes);
//        nodes.forEach(System.out::println);
//        edges.forEach(System.out::println);
        setEdges(nodes, edges);
        nodes.forEach(System.out::println);


    }

    private void setEdges(List<Node<Integer, Integer>> nodes
            , List<Edge<Integer>> edges) {
        for (Node<Integer, Integer> node : nodes) {
            node.edges = getEdges(node, edges);
            node.nexts = getNextNode(node, edges);
            node.out = out;
            node.in = getIn(node, edges);
        }
    }

    private Integer getIn(Node<Integer, Integer> node, List<Edge<Integer>> edges) {
        Integer in = 0;
        for (Edge<Integer> edge : edges) {
            if (edge.to.equals(node)) {
                in++;
            }
        }
        return in;
    }

    private List<Edge<Integer>> getEdges(Node<Integer, Integer> node, List<Edge<Integer>> edges) {
        List<Edge<Integer>> temp = new ArrayList<>();
        out = 0;
        for (Edge<Integer> edge : edges) {
            if (edge.from.equals(node)) {
                temp.add(edge);
                out++;
            }
        }
        return temp;
    }

    private List<Node<Integer, Integer>> getNextNode(Node<Integer, Integer> node, List<Edge<Integer>> edges) {
        List<Node<Integer, Integer>> nodesList = new ArrayList<>();
        for (Edge<Integer> edge : edges) {
            if (edge.from.equals(node)) {
                nodesList.add((Node<Integer, Integer>) edge.to);
            }
        }
        return nodesList;
    }

    private List<Node<Integer, Integer>> getNode() {
        List<Node<Integer, Integer>> nodes = new ArrayList<>();
        Node<Integer, Integer> a = new Node<>(1);
        Node<Integer, Integer> b = new Node<>(2);
        Node<Integer, Integer> c = new Node<>(3);
        Node<Integer, Integer> d = new Node<>(4);
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        return nodes;
    }

    private List<Edge<Integer>> getEdges(List<Node<Integer, Integer>> nodes) {
        List<Edge<Integer>> edges = new ArrayList<>();
        // a <---> b
        Edge<Integer> edge;
        edge = new Edge<>(3);
        edge.from = nodes.get(0);
        edge.to = nodes.get(1);
        edges.add(edge);
        edge = new Edge<>(3);
        edge.from = nodes.get(1);
        edge.to = nodes.get(0);
        edges.add(edge);
        // a <---> c
        edge = new Edge<>(7);
        edge.from = nodes.get(0);
        edge.to = nodes.get(2);
        edges.add(edge);
        edge = new Edge<>(7);
        edge.from = nodes.get(2);
        edge.to = nodes.get(0);
        edges.add(edge);
        // a <---> d
        edge = new Edge<>(2);
        edge.from = nodes.get(0);
        edge.to = nodes.get(3);
        edges.add(edge);
        edge = new Edge<>(2);
        edge.from = nodes.get(3);
        edge.to = nodes.get(0);
        edges.add(edge);
        // b <---> d
        edge = new Edge<>(1);
        edge.from = nodes.get(1);
        edge.to = nodes.get(3);
        edges.add(edge);
        edge = new Edge<>(1);
        edge.from = nodes.get(3);
        edge.to = nodes.get(1);
        edges.add(edge);

        return edges;
    }

    // Union-Find Set
    private static class UnionFind<N, E> {
        /**
         * 父节点信息
         */
        private Map<Node<N, E>, Node<N, E>> fatherMap;
        /**
         * 节点的大小信息
         */
        private Map<Node<N, E>, Integer> sizeMap;

        public UnionFind() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        // 初始化
        public void makeSets(Collection<Node<N, E>> nodes) {
            for (Node<N, E> node : nodes) {
                makeSet(node);
            }
        }

        private void makeSet(Node<N, E> node) {
            this.fatherMap.put(node, node);
            this.sizeMap.put(node, 1);
        }

        // 找父节点
        private Node<N, E> findFather(Node<N, E> n) {
            Stack<Node<N, E>> stack = new Stack<>();
            while (n != fatherMap.get(n)) {
                stack.push(n);
                n = fatherMap.get(n);
            }
            // 优化：将经过的的子节点，连接上顶层的父节点。
            while (!stack.isEmpty()) {
                fatherMap.put(stack.pop(), n);
            }
            return n;
        }

        // 判断两个节点，是否是同一个父节点
        public boolean isSameSet(Node<N, E> a, Node<N, E> b) {
            return findFather(a).equals(findFather(b));
        }

        // 结合节点a 、b ;
        public void union(Node<N, E> a, Node<N, E> b) {
            if (a == null || b == null) {
                return;
            }
            a = findFather(a);
            b = findFather(b);
            if (!a.equals(b)) {
                int aSize = sizeMap.get(a);
                int bSize = sizeMap.get(b);
                if (aSize < bSize) {
                    fatherMap.put(a, b);
                    sizeMap.remove(a);
                    sizeMap.put(b, aSize + bSize);
                } else {
                    fatherMap.put(b, a);
                    sizeMap.remove(b);
                    sizeMap.put(a, aSize + bSize);
                }

            }

        }

    }

}

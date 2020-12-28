package com.zzt.struct.figure.application;

import com.zzt.struct.figure.struct.Edge;
import com.zzt.struct.figure.struct.Graph;
import com.zzt.struct.figure.struct.Node;

import java.util.*;

/**
 * 描述：<br> 图：最小生成树 Kruskal 算法
 * </>
 *
 * @author zzt
 */
public class Figure_Kruskal {

    public static Set<Edge> kruskalMST(Graph<?> graph) {
        Set<Edge> edges = new HashSet<>();
        AndCollection collection = new AndCollection();
        collection.add((Node<?>) graph.nodeMap.values());
        /*PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<>(new MyEdgeComparator());
        graph.edges.forEach(edgePriorityQueue::offer);*/
        List<Edge> edgeList = new ArrayList<>(graph.edges); // 可以使用堆结构排序
        edgeList.sort(new MyEdgeComparator());

        for (Edge edge : edgeList) {
            Node<?> fromNode = edge.fromNode;
            Node<?> toNode = edge.toNode;
            if (!collection.isSame(fromNode, toNode)) {
                collection.union(fromNode, toNode);
                edges.add(edge);
            }
        }

        return edges;
    }

    private static class MyEdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight - o2.weight;
        }
    }

    private static class AndCollection {
        Map<Node<?>, Node<?>> parentMap;
        Map<Node<?>, Integer> sizeMap;

        public AndCollection() {
            parentMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void add(Node<?> a) {
            if (!parentMap.containsKey(a)) {
                parentMap.put(a, a);
                sizeMap.put(a, 1);
            }
        }

        public void add(List<Node<?>> nodes) {
            parentMap.clear();
            sizeMap.clear();
            for (Node<?> node : nodes) {
                parentMap.put(node, node);
                sizeMap.put(node, 1);
            }

        }

        public Node<?> findFather(Node<?> node) {
            Stack<Node<?>> path = new Stack<>();    // 经过的点（优化：将经过的点，直接与最终父节点连接）
            Node<?> help;
            while (!(help = parentMap.get(node)).equals(node)) {
                path.push(help);
                node = help;
            }
            while (!path.isEmpty()) {
                Node<?> pop = path.pop();
                parentMap.put(pop, help);
                // sizeMap.remove(pop);
            }
            return help;
        }

        public boolean isSame(Node<?> a, Node<?> b) {
            return findFather(a).equals(findFather(b));
        }

        public void union(Node<?> a, Node<?> b) {
            if (a == null || b == null) {
                return;
            }
            Node<?> aFather = findFather(a);
            Node<?> bFather = findFather(b);
            int aSize = sizeMap.get(aFather);
            int bSize = sizeMap.get(bFather);

            if (aFather.equals(bFather)) return;

            if (aSize > bSize) {
                parentMap.put(bFather, aFather);
                sizeMap.put(aFather, aSize + bSize);
                sizeMap.remove(bFather);
            } else {
                parentMap.put(aFather, bFather);
                sizeMap.put(bFather, aSize + bSize);
                sizeMap.remove(aFather);
            }
        }
    }

}

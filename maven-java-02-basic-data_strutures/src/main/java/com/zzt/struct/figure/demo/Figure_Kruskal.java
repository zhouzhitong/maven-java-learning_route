package com.zzt.struct.figure.demo;

import com.zzt.struct.figure.struct.Edge;
import com.zzt.struct.figure.struct.Graph;
import com.zzt.struct.figure.struct.Node;

import java.util.*;

/**
 * 描述：<br>图：最小生成树 Kruskal 算法
 * 通过边，确定节点
 * </>
 *
 * @author zzt
 */
public class Figure_Kruskal {

    public static Set<Edge> kruskalMST(Graph<?> graph) {
        Set<Edge> edges = new HashSet<>();
        AndCollection collection = new AndCollection();
        // 初始化 并查集
        graph.nodeMap.values().forEach(collection::add);
        List<Edge> edgeList = new ArrayList<>(graph.edges);
        edgeList.sort(Comparator.comparingInt(a -> a.weight));
        for (Edge edge : edgeList) {
            Node<?> fromNode = edge.fromNode;
            Node<?> toNode = edge.toNode;
            if (!collection.isSame(fromNode, toNode)) {
                edges.add(edge);
                collection.union(fromNode, toNode);
            }
        }
        return edges;
    }

    private static class AndCollection {
        Map<Node<?>, Node<?>> parentNodes;
        Map<Node<?>, Integer> sizeMap;
        Set<Node<?>> exitsNodes;

        public AndCollection() {
            parentNodes = new HashMap<>();
            sizeMap = new HashMap<>();
            exitsNodes = new HashSet<>();
        }

        public Node<?> findFather(Node<?> child) {
            Stack<Node<?>> childrenStack = new Stack<>();
            Node<?> parent;
            while ((parent = parentNodes.get(child)) != child) {
                childrenStack.push(parent);
                child = parent;
            }
            while (!childrenStack.isEmpty()) {
                parentNodes.put(childrenStack.pop(), parent);
            }
            return parent;
        }

        public boolean isSame(Node<?> a, Node<?> b) {
            return findFather(a).equals(findFather(b));
        }

        public void add(Node<?> node) {
            if (exitsNodes.add(node)) {
                parentNodes.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public void union(Node<?> a, Node<?> b) {
            Node<?> aFather = findFather(a);
            Node<?> bFather = findFather(b);
            if (!aFather.equals(bFather)) {
                Integer aSize = sizeMap.remove(aFather);
                Integer bSize = sizeMap.remove(bFather);
                if (aSize > bSize) {
                    parentNodes.put(bFather, aFather);
                    // sizeMap.remove(bFather);
                    sizeMap.put(aFather, aSize + bSize);
                } else {
                    parentNodes.put(aFather, bFather);
                    // sizeMap.remove(aFather);
                    sizeMap.put(bFather, aSize + bSize);
                }
            }
        }

    }

}
